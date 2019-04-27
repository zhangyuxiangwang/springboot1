package com.yi23.springboot;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.util.*;

import static java.nio.charset.StandardCharsets.UTF_8;

@RestController
public class ExcelController {

    @RequestMapping(value = "/excel")
    public String excel(HttpServletRequest request, HttpServletResponse response){

        String params[]={"姓名","年龄","性别","职业"};

        String map[]={"name","age","sex","emp"};

        List<Object> lists=new ArrayList<>();

        for(int i=0;i<10;i++){
            Map<String ,Object> map1 = new HashMap<>();
            map1.put("name","王哈哈哈ffsah \r\n");
            map1.put("age","hgshdh，hggsdhshd（hgsahgg）(sdjjsd)：jjsjdh");
            map1.put("sex","sdsdjsj\r\nsjdjssjdjs，");
            map1.put("emp",""+i);
            lists.add(map1);
        }

        HSSFWorkbook hook=excelHss(params,map,lists);

        try{
            ServletOutputStream stream =
                    response.getOutputStream();
            ByteArrayOutputStream opt=new ByteArrayOutputStream();
            hook.write(opt);
//            String name="学生信息";
//            name.
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Cache-Control","max-age=0");
            response.setCharacterEncoding("utf-8");
            response.setHeader("Parama","public");
            //Student 这个是导出的文件名称
            response.setHeader("Content-Disposition","attachment; filename=Student.excel");
            response.setContentLength(opt.size());
            response.setHeader("Refresh", "3;url=http://www.baidu.com"); //告诉客户端 三秒后刷新
            stream.write(opt.toByteArray());
            opt.flush();
            stream.flush();
        }catch (Exception e){
            System.out.println(e);
        }
        return "success";
    }


    /**
     * 导出csv一定要注意：
     * https://www.cnblogs.com/softidea/p/5313516.html
     * CSV文件默认以英文逗号做为列分隔符，换行符作为行分隔符。
     * 如果不提供网页形式只用命令行或二进制程序输出数据到CSV，只需要将数据段按,分割，行按\n分割，写入到一个.csv文件即可。
     * 但有时字段里含有,和换行符就麻烦了，数据输出会出现混乱
     *
     * 出现乱码
     * https://blog.csdn.net/qq_39478853/article/details/80325868
     * 1、OutputStreamWriter osw = new OutputStreamWriter(resp.getOutputStream(), "UTF-8");    
     * // 要输出的内容    
     * result = (String)contentMap.get(RESPONSE_RESULT);    
     * resp.setHeader("Content-Disposition", "attachment;filename=test.csv");    
     * osw.write(new String(new byte[] { (byte) 0xEF, (byte) 0xBB,(byte) 0xBF }));    
     * osw.write(result);    
     * osw.flush();  
     * 2、
     * out = response.getOutputStream();
     * //加上UTF-8文件的标识字符
     * out.write(new   byte []{( byte ) 0xEF ,( byte ) 0xBB ,( byte ) 0xBF });
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/csv")
    public String csv(HttpServletRequest request, HttpServletResponse response){

        List<String> headers =Arrays.asList("姓名","年龄","性别","职业");
        List<String> fields =Arrays.asList("name","age","sex","emp");

        StringBuilder builder = new StringBuilder();
        List<Map<String, Object>> contentList = new ArrayList<>(8);
        for(int i=0;i<10;i++){
            Map<String ,Object> map1 = new HashMap<>();
            map1.put("name","王哈哈哈ffsah\r");
            map1.put("age","hgshdh，hggsdhshd（hgsahgg）(sdjjsd)：jjsjdh");
            map1.put("sex","sdsdjsj sjdjssjdjs，");
            map1.put("emp",""+i);
            contentList.add(map1);
        }
        builder.append(String.join(",", headers));
        builder.append("\r\n");
        contentList
                .forEach(m -> {
                    List<String> tempValueList = new ArrayList<>(5);
                    fields.forEach(key -> {
                        Object value = m.getOrDefault(key, "");
                        tempValueList.add(removeEscapeCharacter(String.valueOf(value).replaceAll(",", "，")+""));
                    });
                    builder.append(String.join(",", tempValueList));
                    builder.append("\r\n");
                });

        try{
            ServletOutputStream stream =
                    response.getOutputStream();
            ByteArrayOutputStream opt=new ByteArrayOutputStream();
            opt.write(builder.toString().getBytes(UTF_8));

//            String name="学生信息";
//            name.
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Cache-Control","max-age=0");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Parama","public");
            //Student 这个是导出的文件名称
            response.setHeader("Content-Disposition","attachment; filename=Student.csv");
            response.setContentLength(opt.size());
            response.setHeader("Refresh", "3;url=http://www.baidu.com"); //告诉客户端 三秒后刷新
            stream.write(new   byte []{( byte ) 0xEF ,( byte ) 0xBB ,( byte ) 0xBF });
            stream.write(opt.toByteArray());
            opt.flush();
            stream.flush();
        }catch (Exception e){
            System.out.println(e);
        }
        return "success";
    }

    /**
     * 去掉特殊字符
     * @param str
     * @return
     */
    public static String removeEscapeCharacter(String str){
        if(StringUtils.isNotEmpty(str)){
            str = str.replaceAll("\b|\r\n|\t|\f|\r|\0|\n","");
        }
        return str;
    }

    private HSSFWorkbook excelHss(String params[],String map[],List<Object> lists){
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        List<List> list = splitList(lists, 9999999);
        for(int i=0;i<list.size();i++){
            System.out.println("生成表格");
            HSSFSheet sheet =hssfWorkbook.createSheet("学生表-01");
            sheet.setDefaultColumnWidth(15);
            //生成一个样式
            HSSFCellStyle style = hssfWorkbook.createCellStyle();
            style.setBorderBottom(HSSFCellStyle.BORDER_DASHED);
            HSSFRow row = sheet.createRow(0);
            for(int j=0;j<params.length;j++){
                HSSFCell cell = row.createCell(j);
                HSSFRichTextString text = new HSSFRichTextString(params[j]);
                cell.setCellValue(text);
            }
            for(int j=0;j<list.get(i).size();j++){
                row= sheet.createRow(j + 1);
                System.out.println(list.get(i).get(j)+"-----list.get(i)");
                Map<String ,Object> mapes= (Map<String, Object>) list.get(i).get(j);
                for(int v=0;v<map.length;v++){
                    row.createCell(v).setCellValue(mapes.get(map[v]).toString());
                }
            }
        }
        return hssfWorkbook;
    }
    private  List<List> splitList(List<Object> targe, int size) {
        List<List> listArr = new ArrayList<>();
        int arrSize = targe.size() % size == 0 ? targe.size() / size : targe.size() / size + 1;
        for (int i = 0; i < arrSize; i++) {
            List<Object> sub = new ArrayList<>();
            for (int j = i * size; j <= size * (i + 1) - 1; j++) {
                if (j <= targe.size() - 1) {
                    sub.add(targe.get(j));
                }
            }
            listArr.add(sub);
        }
        return listArr;
    }
}
