package com.xmc.service.impl;

import com.xmc.dao.NoticeDao;
import com.xmc.entity.Notice;
import com.xmc.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xyd on 16/6/12.
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    NoticeDao noticeDao;

    public void add(String content) {
        Notice notice = new Notice();
        notice.setContent(content);
        notice.setId(1);
        noticeDao.updateNotice(notice);
    }

    public String getContent() {
        return noticeDao.getNotice().toString();
    }
}
