package com.xmc.dao;

import com.xmc.annotation.MybatisComponent;
import com.xmc.entity.Notice;

/**
 * Created by xmc1993 on 16/6/15.
 */
@MybatisComponent
public interface NoticeDao {

    void insertNotice(Notice notice);

    void updateNotice(Notice notice);

    Notice getNotice();
}
