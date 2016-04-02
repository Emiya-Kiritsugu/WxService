package com.xmc.service.impl;

import com.xmc.dao.ClockDao;
import com.xmc.entity.Clock;
import com.xmc.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2015/12/4.
 */
@Service
public class LoginServiceImpl implements LoginService{
    @Autowired
    ClockDao clockDao;

    public void login(String name, String password) {

    }

    public Clock getClockById(Integer id){
        Clock clock = clockDao.getClockById(id);
        return clock;
    }
}
