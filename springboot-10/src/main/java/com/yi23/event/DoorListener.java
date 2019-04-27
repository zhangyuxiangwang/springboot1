package com.yi23.event;


import java.util.EventListener;

/**
 * @Author : 王斌
 * @Date : 2019/3/16 下午4:00
 * @Description 描述
 */
public class DoorListener implements EventListener {

    public void doorEvent(DoorEvent event) {
        if (event.getValue() != null && event.getValue().equals("open")) {
            System.out.println("门1打开");
        } else {
            System.out.println("门1关闭");
        }
    }
}
