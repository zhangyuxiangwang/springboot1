package com.yi23.springboot;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class UserController {

    @RequestMapping(value = "/test")
    @ResponseBody
    public String test(HttpServletResponse response, HttpServletRequest request){
         //导出数据
        String[] headers = {"PID", "商品名称", "款号", "品牌", "颜色", "品类", "材质", "材质描述","上架状态" ,
                "采购深度","可出租数","已出租数","新品数","可准备数","售卖件数","退出流通数","退回供应商数","衣二三买断数","出租次数", "供货价",
                "吊牌价", "销售价","新品销售价", "租金","初次上架时间"};
        String[] params = {"product_id", "product_name", "partner_pid", "brand_en_name", "color_name", "type_name",
                "material_name", "material_detail","isAliveName" ,"stockCount","rentable","rented","newSaleNum","staging","soldOne",
                "outCirculate","returned","yi23BuyOff","times", "supply_price", "market_price", "sale_price",
                "original_price", "rent_price", "initial_sale_time"};

        List<Map<String, Object>> list = new ArrayList<>();
        Map<String ,Object > map = new HashMap<>();
        for(int i=0;i<params.length;i++){

            if(i==params.length-1){
                map.put(params[i],new Date());
            }else{
                map.put(params[i],10+i);
            }
        }

        list.add(map);

        if (list.size() > 0) {
            HSSFWorkbook workbook = exportExcel("商品列表", headers, params, list, request, response, "yyyy-MM-dd HH:mm:ss");
            try {
                ServletOutputStream sos = response.getOutputStream();
                ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                workbook.write(buffer);
                response.setContentType("application/vnd.ms-excel");
                response.setContentLength(buffer.size());
                response.setHeader("Content-Disposition", "attachment; filename=productList.xls");
                response.setHeader("Pragma", "public");
                response.setHeader("Cache-Control", "max-age=0");
                sos.write(buffer.toByteArray());
                buffer.flush();
                sos.flush();
            } catch (Exception e) {
                System.out.println("------");
            }
        }
        return "success";
    }

    private HSSFWorkbook exportExcel(String title, String[] headers, String[] fields, List list, HttpServletRequest request, HttpServletResponse response, String format){
        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        List<List> subList = splitList(list, 60000);
        System.out.println(subList+"--subList");
        for (int k = 0; k < subList.size(); k++) {
            // 生成一个表格
            HSSFSheet sheet = workbook.createSheet(title + "--" + k);
            // 设置表格默认列宽度为15个字节
            sheet.setDefaultColumnWidth((short) 15);
            // 生成一个样式
            HSSFCellStyle style = workbook.createCellStyle();
            // 设置这些样式
            style.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
            style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            style.setBorderRight(HSSFCellStyle.BORDER_THIN);
            style.setBorderTop(HSSFCellStyle.BORDER_THIN);
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
            // 生成一个字体
            HSSFFont font = workbook.createFont();
            font.setColor(HSSFColor.BLACK.index);
            font.setFontHeightInPoints((short) 12);
            font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            // 把字体应用到当前的样式
            style.setFont(font);
            // 生成并设置另一个样式
            HSSFCellStyle style2 = workbook.createCellStyle();
            style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
            style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
            style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
            style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
            style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
            // 生成另一个字体
            HSSFFont font2 = workbook.createFont();
            font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
            // 把字体应用到当前的样式
            style2.setFont(font2);

            // 声明一个画图的顶级管理器
//        HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
            // 定义注释的大小和位置,详见文档
//        HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0,
//                0, 0, 0, (short) 4, 2, (short) 6, 5));
//        // 设置注释内容
//        comment.setString(new HSSFRichTextString("可以在POI中添加注释！"));
//        // 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.
//        comment.setAuthor("leno");

            // 产生表格标题行
            HSSFRow row = sheet.createRow(0);
            for (short i = 0; i < headers.length; i++) {
                HSSFCell cell = row.createCell(i);
                cell.setCellStyle(style);
                HSSFRichTextString text = new HSSFRichTextString(headers[i]);
                cell.setCellValue(text);
            }

            for (int i = 0; i < subList.get(k).size(); i++) {
                row = sheet.createRow(i + 1);
                Map map = (Map) subList.get(k).get(i);

                for (int j = 0; j < fields.length; j++) {
                    int idx = fields[j].indexOf("[");
                    if (idx > 0 && fields[j].endsWith("]")) {//list里有list
                        String top = fields[j].substring(0, idx);
                        String[] bodys = fields[j].substring(idx + 1, fields[j].length() - 1).split(",");
                        if (map.get(top) instanceof List) {
                            List<Map<String, Object>> lists = (List<Map<String, Object>>) map.get(top);
                            StringBuffer sb = new StringBuffer();
                            for (int l = 0; l < lists.size(); l++) {
                                Map<String, Object> mapValue = lists.get(l);
                                for (String body : bodys) {
                                    String[] arrKey = body.split(":");
                                    sb.append(arrKey[0]);
                                    sb.append(":");
                                    sb.append(mapValue.get(arrKey[1]));
                                }
                                if (l != lists.size() - 1) {
                                    sb.append("\r");
                                }
                            }
                            row.createCell(j).setCellValue(sb.toString());
                        }
                    } else {
                        row.createCell(j).setCellValue(formatRowVal(map.get(fields[j]), format));
                    }
                }
            }
        }

        return workbook;

    }
    private static String formatRowVal(Object value, String dateFormat) {
        // 判断值的类型后进行强制类型转换
        String textValue = null;
        if (value == null) {
            return "";
        }
        if (value instanceof Boolean) {
            boolean bValue = (Boolean) value;
            textValue = "是";
            if (!bValue) {
                textValue = "否";
            }
        } else if (value instanceof Date) {
            Date date = (Date) value;
            SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
            textValue = sdf.format(date);
        } else if (value instanceof byte[]) {
        } else {
            // 其它数据类型都当作字符串简单处理
            textValue = value.toString();
        }
        return textValue;
    }

    public static List<Object> splitList(List<Object> targe, int size) {
        List<Object> listArr = new ArrayList<>();
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
