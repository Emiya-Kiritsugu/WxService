package com.xmc.service;

import com.xmc.entity.Clock;

/**
 * Created by Administrator on 2015/12/4.
 */
public interface LoginService {

    void login(String name, String password);

    public Clock getClockById(Integer id);
}
