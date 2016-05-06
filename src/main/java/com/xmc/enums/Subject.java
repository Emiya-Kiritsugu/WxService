package com.xmc.enums;

/**
 * Created by xmc1993 on 16/5/6.
 */
public enum Subject {

    MATH("数学"),
    CHINESE("语文"),
    ENGLISH("英语"),
    PHYSICS("物理"),
    CHEMISTRY("化学"),
    BIOLOGY("生物"),
    POLITICS("政治"),
    HISTORY("历史"),
    GEOGRAPHY("地理"),
    OTHERS("其他");


    public final String description;

    Subject(String description){
        this.description = description;
    }
}
