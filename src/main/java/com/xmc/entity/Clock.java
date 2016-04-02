package com.xmc.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/12/7.
 */

@Data
public class Clock implements Serializable{
    private String id;
    private String name;
    private String password;
}
