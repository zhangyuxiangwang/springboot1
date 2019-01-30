package com.yi23.springboot.bean;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * org.apache.commons.lang.StringUtils
 * 测试这个类的一些方法
 * @王斌
 * @date 2018-12-12
 */
public class TestStringUtilsCommentLang3 {

    public static void main(String[] args) {

        String name=null;

        System.out.println(StringUtils.isEmpty(name)+"--isEmpty");
        System.out.println(StringUtils.isBlank(name));
        /**
         * 这个是判断字符串为null和""是返回false，否则返回true，他不会去除空格。
         */
        System.out.println(StringUtils.isNotEmpty(name)+"--isNotEmpty");
        System.out.println(StringUtils.isNotBlank(name)+"--isNotBlank");
        /**
         * 如果为空则放回null，也会去了空格（只能去除前后的空格，不能去除中间的空格）
         */
        System.out.println(StringUtils.trimToNull(name)+"--trimToNull");
        /**
         * 这个trimToEmpty方法只是先判断字符串是否为空，为空则返回，不为空调用string的trim去空格
         */
        System.out.println(StringUtils.trimToEmpty(name) +"--trimToEmpty");

        /**
         * 这个方法是能去除所有的空格的
         */
        System.out.println(StringUtils.deleteWhitespace(name));

        /**
         * 字符串左边补全
         */
        String age="  ";
        System.out.println(StringUtils.leftPad(age,5,"1"));

        /**
         * 这个是判断字符串是不是全部是由数字组成的，如果是的话返回true（有空格也不行）
         */
        System.out.println(StringUtils.isNumeric("1232312"));
        /**
         * 判断字符串是不是全部是由字母组成的，如果是的话返回true
         */
        System.out.println(StringUtils.isAlpha("sdwedcsd "));
        /**
         * 判断这个是不是全部是由字母和空格组成的
         */
        System.out.println(StringUtils.isAlphaSpace("hsadsjd  bshd"));
        /**
         * 判断是不是全部是由字母和数字组成的
         */
        System.out.println(StringUtils.isAlphanumeric("dsjheghd23e3"));

        /**
         * 颠倒字符串顺序
         */
        System.out.println(StringUtils.reverse("sdfsdfewdcdssd2321"));

        /**
         * 出现的次数
         */
        System.out.println(StringUtils.countMatches("whfgedsfgesjdshjfgesdsj","fge"));

        System.out.println(StringUtils.abbreviate("sdgfeew",6));
        /**
         * 分割字符串
         */
        System.out.println(ArrayUtils.toString(StringUtils.split("2312,434sd 23|0d."," ,.|")));

        System.out.println(StringUtils.contains("ewqiidsdssaa","dsdss"));
    }
}
