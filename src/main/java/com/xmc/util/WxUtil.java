package com.xmc.util;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.WxMpCustomMessage;

/**
 * Created by xmc1993 on 16/4/1.
 */
public class WxUtil {

    private static WxMpInMemoryConfigStorage configStorage = new WxMpInMemoryConfigStorage();
    private static WxMpService wxMpService;
    static{
        configStorage.setAppId("...");
        configStorage.setSecret("...");
        configStorage.setToken("...");
        configStorage.setAesKey("...");

        wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(configStorage);

    }

    public static WxMpService getWxMpService(){
        return wxMpService;
    }

    public static void customMessageSned(String msg) throws WxErrorException {
        // https://mp.weixin.qq.com/debug/cgi-bin/apiinfo?t=index&type=用户管理&form=获取关注者列表接口%20/user/get
        String openid = "...";
        WxMpCustomMessage message = WxMpCustomMessage.TEXT().toUser(openid).content(msg).build();
        getWxMpService().customMessageSend(message);
    }

}
