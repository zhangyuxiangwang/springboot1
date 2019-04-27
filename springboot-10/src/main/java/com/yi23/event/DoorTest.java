package com.yi23.event;

/**
 * @Author : 王斌
 * @Date : 2019/3/16 下午4:06
 * @Description 描述
 */
public class DoorTest {

    public static void main(String[] args) {

        Door door = new Door();
        door.setStateListener(new DoorListener());
        door.setNameListener (new DoorNameListener());
        // 开门
        door.setState("open");
        System.out.println("我已经进来了");
        // 关门
        door.setState("close");
        // 改名
        door.setName("dengzy");
    }
}
