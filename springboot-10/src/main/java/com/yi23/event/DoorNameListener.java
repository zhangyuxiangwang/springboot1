package com.yi23.event;


import java.util.EventListener;

/**
 * @Author : 王斌
 * @Date : 2019/3/16 下午4:04
 * @Description 描述
 */
public class DoorNameListener implements EventListener {
    public void doorEvent(DoorEvent event) {
        Door door = (Door) event.getSource();
        System.out.println("I got a new name,named \"" + door.getName() + "\"");
    }
}
