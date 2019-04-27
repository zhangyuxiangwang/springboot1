package com.yi23.springboot.interview;

import com.alibaba.druid.filter.AutoLoad;
import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.collections4.MapUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author : 王斌
 * @Date : 2019/4/24 上午10:30
 * @Description 描述
 */
public class Testlamada {

    private static final Integer CONFIG=10;

    public static void main(String[] args) {
        testLamada();
    }

    public static void testLamada(){

        List<Map<String,Object>> lists = data();

        System.out.println(JSON.toJSONString(lists));

        int user = lists.stream().collect(Collectors.groupingBy(item -> item.get("user"))).size();
        //allMatch 是全匹配 anyMatch 只要有一个匹配的返回true  noneMatch 一个都没有匹配上，返回true
        boolean total = lists.stream().noneMatch(stringObjectMap -> MapUtils.getInteger(stringObjectMap,"total")==1);
        Integer total1 = lists.stream().map(map -> MapUtils.getInteger(map, "total")).reduce(Integer::sum).get();

        int i = lists.stream().map(map -> MapUtils.getInteger(map, "total")).reduce(Integer::sum).orElse(10);

        System.out.println(user+"total:"+total+"--total1="+total1+"----i="+1);

        List<Users> list = dataUser();

    }

    public static List<Map<String,Object>> data(){
        List<Map<String,Object>> lists = new ArrayList<>(CONFIG);
        for (int i=0;i<CONFIG;i++){
            Map<String,Object> map = new HashMap<>(3);

            map.put("send",i+"hao");
            if(i==4){
                map.put("user",i);
            }else{
                map.put("user","");
            }

            map.put("total",i+10);


            if(i==6 || i==8){
                map.put("type",i);
            }else{
                map.put("type","");
            }
            lists.add(map);
        }

        return lists;
    }
    public static List<Users> dataUser(){

        List<Users> lists = new ArrayList<>(CONFIG);
        for (int i=0;i<CONFIG;i++){
            Users build = Users.builder().age(i + 10).name("a" + i).sex(i).build();
            lists.add(build);
        }
        return lists;
    };

}

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class Users{

    private Integer age;

    private String name;

    private Integer sex;
}