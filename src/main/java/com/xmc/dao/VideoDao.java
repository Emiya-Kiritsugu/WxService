package com.xmc.dao;

import com.xmc.annotation.MybatisComponent;
import com.xmc.entity.Student;
import com.xmc.entity.Video;

import java.util.List;

/**
 * Created by xmc1993 on 16/4/8.
 */
@MybatisComponent
public interface VideoDao {

    void insert(Video video);

    void deleteById(int id);

    void updateById(Video video);

    Video getVideoById(int id);

    List<Video> getAllVideos();
}
