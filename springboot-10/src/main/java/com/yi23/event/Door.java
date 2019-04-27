package com.yi23.event;

/**
 * @Author : 王斌
 * @Date : 2019/3/16 下午4:03
 * @Description 描述
 */
public class Door {
    private String state = "";
    private String name = "";
    private DoorListener stateListener;
    private DoorNameListener  nameListener;

    public void setState(String newValue) {
        if (state != newValue) {
            state = newValue;
            if (stateListener != null){
                //注意参数传递
                DoorEvent event = new DoorEvent(this, "state",newValue);
                stateListener.doorEvent(event);
            }
        }
    }

    public void setName(String newValue) {
        if (name != newValue) {
            name = newValue;
            if (nameListener != null){
                DoorEvent event = new DoorEvent(this,"name", newValue);
                nameListener.doorEvent(event);
            }
        }
    }

    public void setStateListener(DoorListener stateListener) {
        this.stateListener = stateListener;
    }

    public void setNameListener(DoorNameListener nameListener) {
        this.nameListener = nameListener;
    }

    public String getState() {
        return state;
    }

    public String getName() {
        return name;
    }
}
