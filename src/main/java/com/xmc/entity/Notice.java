package com.xmc.entity;

import java.io.Serializable;

/**
 * Created by xmc1993 on 16/6/15.
 */
public class Notice implements Serializable{
    private Integer id;
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString(){
        return content;
    }
}
