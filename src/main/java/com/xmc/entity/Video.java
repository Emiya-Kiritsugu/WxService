package com.xmc.entity;

import com.xmc.enums.Grade;
import com.xmc.enums.Subject;

import java.io.Serializable;

/**
 * Created by xmc1993 on 16/4/8.
 */
public class Video implements Serializable{
    private Integer id;
    private Grade grade;
    private Subject subject;
    private String name;
    private String description;
    private String url;

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
