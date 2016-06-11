package com.xmc.enums;

/**
 * Created by xmc1993 on 16/5/6.
 */
public enum Grade {

    JUNIOR_THREE("初三"),
    SENIOR_ONE("高一"),
    SENIOR_TWO("高二"),
    SENIOR_THREE("高三"),
    OTHERS("其他");

    public final String description;

    Grade(String description){
        this.description = description;
    }

}
