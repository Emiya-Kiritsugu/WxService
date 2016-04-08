package com.xmc.entity;

import java.io.Serializable;

/**
 * Created by xmc1993 on 16/4/8.
 */
public class Teacher implements Serializable{
    private Integer teaNo;
    private String name;
    private String photoUrl;
    private String profile;
    private String achievement;

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAchievement() {
        return achievement;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }

    public Integer getTeaNo() {
        return teaNo;

    }

    public void setTeaNo(Integer teaNo) {
        this.teaNo = teaNo;
    }
}
