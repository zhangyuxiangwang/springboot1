package com.yi23.springboot.pattern;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wangbin
 * @date 2019-01-14
 * 这个类主要学习正则表达式
 * 学习的地址：
 * http://www.runoob.com/regexp/regexp-tutorial.html
 */
public class TestPattern {


    /**
     * 只能输入数字和逗号,逗号不在开头和结尾,不能出现连着的两个以上的逗号,可以全是数字
     * @param str
     * @return
     *
     * ^([0-9]+,)*[0-9]+$ 的解释：^表示开始匹配，[0-9]表示匹配一个，+表示可以匹配多个0-9，
     */
    public static boolean onlyNumbersAndEnglishCommas(String str){

        if(str==null || str==""){
            return true;
        }
        String reg="^([0-9]+,)*[0-9]+$";
        return str.matches(reg);
    }

    /**
     * 对价格做一个校验  小数点保留两位有效小数，且金额保留9位
     * @param str
     * @return
     * ^([1-9]{1,1}\d{0,8}|[0])(\.\d{0,2})?$  的解释：|表示或者；{0,8}表示长度
     */
    public static boolean checkPrice(String str) {
        if(str==null){
            return false;
        }
        String reg = "^([1-9]{1,1}\\d{0,8}|[0])(\\.\\d{0,2})?$";
        return str.matches(reg);
    }


    /**
     * @param str
     * @return
     */
    public static boolean takeOutNumbers(String str) {
        if(str==null){
            return false;
        }
        String reg = "/[0-9]+/";
        Pattern pattern=Pattern.compile("/[0-9]+/");
        return str.matches(str);
    }


    public static void main(String[] args) {

        System.out.println();
    }

    /**
     * 去除转义字符
     * @param str
     * @return
     */
    public static String removeSpecialCharacters(String str){
        StringBuffer buffer = new StringBuffer();
        if(str==null || str==""){
            return "";
        }else{
            char[] chars = str.toCharArray();
            for (int i=0;i<chars.length;i++){
                switch (chars[i]){
                    case 0:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 34:
                    case 39:
                    case 63:
                    case 92:
                        break;
                    default :
                        buffer.append(chars[i]);
                        break;
                }
            }
        }
        return buffer.toString();
    }


}
