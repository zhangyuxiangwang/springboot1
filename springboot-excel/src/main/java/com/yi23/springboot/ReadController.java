package com.yi23.springboot;

import com.alibaba.fastjson.JSON;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ReadController {

    @RequestMapping(value = "/reader")
    @ResponseBody
    public String reader() throws  Exception{
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(new FileInputStream(new File("/Users/a1/Downloads/Student.xls")));
        int numberOfSheets = hssfWorkbook.getNumberOfSheets();
        System.out.println(numberOfSheets+"---numberOfSheets");
        List<Object> list = new ArrayList<>();
        list.add("--好样的--");
        for(int i=0;i<numberOfSheets;i++){
            HSSFSheet sheetAt = hssfWorkbook.getSheetAt(i);
            int firstRowNum = sheetAt.getFirstRowNum();

            int lastRowNum = sheetAt.getLastRowNum();

            for(int rowNum=firstRowNum;rowNum<=lastRowNum;rowNum++){

                HSSFRow row = sheetAt.getRow(rowNum);
                if(row==null){
                    continue;
                }
                short firstCellNum = row.getFirstCellNum();
                short lastCellNum = row.getLastCellNum();
                Map<String,Object> map = new HashMap<>();
                for(int cellNum=firstCellNum;cellNum<lastCellNum;cellNum++){
                    HSSFCell cell = row.getCell(cellNum);

                    map.put("name"+cellNum,cell.getStringCellValue());
                }

                list.add(map);
            }

        }

        return JSON.toJSONString(list);
    }

    @RequestMapping(value = "/testxls")
    @ResponseBody
    public String testxls() throws  Exception{
        XSSFWorkbook hssfWorkbook = new XSSFWorkbook(new FileInputStream(new File("/Users/a1/Downloads/test.xls")));
        int numberOfSheets = hssfWorkbook.getNumberOfSheets();
        System.out.println(numberOfSheets+"---numberOfSheets");
        List<Object> list = new ArrayList<>();
       // list.add("--好样的--");
        for(int i=0;i<numberOfSheets;i++){
            XSSFSheet sheetAt = hssfWorkbook.getSheetAt(i);
            int firstRowNum = sheetAt.getFirstRowNum();

            int lastRowNum = sheetAt.getLastRowNum();
            Map<String ,Object > maps = new HashMap<>();
            if(firstRowNum<=lastRowNum){
                maps.put("row",firstRowNum);
            }

            for(int rowNum=firstRowNum;rowNum<=lastRowNum;rowNum++){
                List<Object> lists = new ArrayList<>();
                XSSFRow row = sheetAt.getRow(rowNum);
                if(row==null){
                    continue;
                }
                short firstCellNum = row.getFirstCellNum();
                short lastCellNum = row.getLastCellNum();
                Map<String,Object> map = new HashMap<>();
                for(int cellNum=firstCellNum;cellNum<lastCellNum;cellNum++){
                    XSSFCell cell = row.getCell(cellNum);
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    if(cellNum==0){
                        map.put("creditorNum",cell.getStringCellValue());
                    }else if(cellNum==1){
                        map.put("debtorNum",cell.getStringCellValue());
                    }else{
                        String value = cell.getStringCellValue();
                        map.put("money",cell.getStringCellValue());
                    }
                }
                if(rowNum!=0) {
                    lists.add(map);
                }
                if(lists!=null && lists.size()>0){
                    maps.put("myslef",lists);
                    list.add(map);
                }
                firstRowNum++;
            }
        }

        for(int i=0;i<list.size();i++){
            Map<String,Object > map2= (Map<String, Object>) list.get(i);
            List<Map<String,Object>> list1 = (List<Map<String, Object>>) map2.get("myslef");
            for(int j=0;j<list1.size();j++){
                Map<String,Object > map3=list1.get(j);
                String creditorNum= (String) map3.get("creditorNum");
                String debtorNum= (String) map3.get("debtorNum");
                String money= (String) map3.get("money");
                if(!"".equals(money) || money==null){

                    for(int k=0;k<list.size();k++){
                        Map<String,Object > map4= (Map<String, Object>) list.get(k);
                        List<Map<String,Object>> list4 = (List<Map<String, Object>>) map2.get("myslef");
                        if(debtorNum.equals("")){

                        }
                    }
                }
            }
        }

        return JSON.toJSONString(list);
    }

}
