package com.xmc.service.impl;

import com.xmc.dao.VideoDao;
import com.xmc.entity.Student;
import com.xmc.entity.Video;
import com.xmc.enums.Grade;
import com.xmc.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xmc1993 on 16/4/22.
 */
@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoDao videoDao;

    public List<Video> getAllVideos() {
        return videoDao.getAllVideos();
    }

    public Video getVideoById(int id) {
        return videoDao.getVideoById(id);
    }

    public void deleteVideoById(int id) {
        videoDao.deleteById(id);
    }

    public void updateVideo(Video video) {
        videoDao.updateById(video);
    }

    public void insertVideo(Video video) {
        videoDao.insert(video);
    }

    public List<Video> getVideosByGrade(Grade grade) {
        return videoDao.getVideosByGrade(grade);
    }
}
