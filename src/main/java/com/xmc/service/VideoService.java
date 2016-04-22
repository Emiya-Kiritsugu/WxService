package com.xmc.service;

import com.xmc.entity.Student;
import com.xmc.entity.Video;

import java.util.List;

/**
 * Created by xmc1993 on 16/4/8.
 */
public interface VideoService {


    List<Video> getAllVideos();

    Video getVideoById(int id);

    void deleteVideoById(int id);


    void updateVideo(Video video);


    void insertVideo(Video video);
}
