package com.xmc.util;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.WxMenu;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.*;
import me.chanjar.weixin.mp.bean.WxMpCustomMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutTextMessage;

import java.util.Map;

/**
 * Created by xmc1993 on 16/4/1.
 */
public class WxUtil {

    private static WxMpInMemoryConfigStorage configStorage = new WxMpInMemoryConfigStorage();
    private static WxMpService wxMpService;
    private static WxMpMessageRouter wxMpMessageRouter;
    static{
        configStorage.setAppId("wx642577ae8e9add78");
        configStorage.setSecret("36fd4c73ee2999d45cac221a7b1c5fd6");
        configStorage.setToken("xmc1993");
        configStorage.setAesKey("1gTTXDq0s9W4459ZPFVDIztu7uy8ddi3oMWhWXJkieg");

        wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(configStorage);

        wxMpMessageRouter = new WxMpMessageRouter(wxMpService);
        wxMpMessageRouter.rule()
                .msgType(WxConsts.CUSTOM_MSG_TEXT)
//                .content("")
//                .async(false)
                .handler(new WxMpMessageHandler() {
                    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMpXmlMessage, Map<String, Object> map,
                                                    WxMpService wxMpService,
                                                    WxSessionManager wxSessionManager) throws WxErrorException {
                        WxMpXmlOutTextMessage m
                                = WxMpXmlOutMessage.TEXT().content("测试加密消息").fromUser(wxMpXmlMessage.getToUserName())
                                .toUser(wxMpXmlMessage.getFromUserName()).build();
                        return m;
                    }
                })
                .end();

    }


    /**
     * 返回微信服务
     * @return
     */
    public static WxMpService getWxMpService(){
        return wxMpService;
    }

    /**
     * 返回configStorage
     * @return
     */
    public static WxMpInMemoryConfigStorage getConfigStorage(){ return configStorage; }

    /**
     * 返回路由
     * @return
     */
    public static WxMpMessageRouter getWxMpMessageRouter(){
        return wxMpMessageRouter;
    }

    /**
     * 向所用用户发送信息
     * @param msg
     * @throws WxErrorException
     */
    public static void customMessageSned(String msg) throws WxErrorException {
        // https://mp.weixin.qq.com/debug/cgi-bin/apiinfo?t=index&type=用户管理&form=获取关注者列表接口%20/user/get
        String openid = "...";
        WxMpCustomMessage message = WxMpCustomMessage.TEXT().toUser(openid).content(msg).build();
        getWxMpService().customMessageSend(message);
    }

    /**
     * check是否来自微信后台的消息
     * @param timestamp
     * @param nonce
     * @param signature
     * @return
     */
    public static boolean isValid(String timestamp, String nonce, String signature){
        return wxMpService.checkSignature(timestamp, nonce, signature);
    }


    private static WxMpMessageHandler handler = new WxMpMessageHandler() {
        public WxMpXmlOutMessage handle(WxMpXmlMessage wxMpXmlMessage, Map<String, Object> map,
                                        WxMpService wxMpService,
                                        WxSessionManager wxSessionManager) throws WxErrorException {
            WxMpXmlOutTextMessage m
                    = WxMpXmlOutMessage.TEXT().content("测试加密消息").fromUser(wxMpXmlMessage.getToUserName())
                    .toUser(wxMpXmlMessage.getFromUserName()).build();
            return m;
        }
    };

}
