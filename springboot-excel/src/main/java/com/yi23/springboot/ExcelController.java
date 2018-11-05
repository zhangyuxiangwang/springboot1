package com.yi23.springboot;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ExcelController {

    @RequestMapping(value = "/excel")
    public String excel(HttpServletRequest request, HttpServletResponse response){

        String params[]={"姓名","年龄","性别","职业"};

        String map[]={"name","age","sex","emp"};

        List<Object> lists=new ArrayList<>();

        for(int i=0;i<10;i++){
            Map<String ,Object> map1 = new HashMap<>();
            map1.put("name",i);
            map1.put("age",i);
            map1.put("sex",i);
            map1.put("emp",i);
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
            response.setHeader("Content-Disposition","attachment; filename=Student.xls");
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
