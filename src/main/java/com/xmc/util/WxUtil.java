package com.xmc.util;

import com.xmc.api.Consts;
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

    private static WxMpInMemoryConfigStorage configStorage;
    private static WxMpService wxMpService;
    private static WxMpMessageRouter wxMpMessageRouter;
    private static WxMenu wxMenu;

    static{
        //TODO 后期改成配置文件实现
        configStorage = new WxMpInMemoryConfigStorage();
        configStorage.setAppId("wx6ecc68917a0e1f07");
        configStorage.setSecret("8a4fadb13b0f07b9b74e74f192b64bfb");
        configStorage.setToken("xmc1993");
        configStorage.setAesKey("vMUdZU1wl0u5810S3XaHGTcqijyIlvv8u2DPc9KyNlv");

        //生成WxMpService
        wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(configStorage);

        //创建菜单
        wxMenu = WxMenu.fromJson(Consts.MENU);
        try {
            wxMpService.menuCreate(wxMenu);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }

        //配置路由的相关信息
        wxMpMessageRouter = new WxMpMessageRouter(wxMpService);
        configWxRouter(wxMpMessageRouter);

    }

    /**
     * 对路由进行配置
     * @param wxMpMessageRouter
     */
    private static void configWxRouter(WxMpMessageRouter wxMpMessageRouter){
        wxMpMessageRouter
                .rule()
                    .msgType(WxConsts.XML_MSG_EVENT)
                    .async(false)
                    .event(WxConsts.BUTTON_CLICK)
                    .handler(new WxClickMpMessageHandler())
                .end()
                .rule()
                    .async(Consts.ASYNC)
                    .msgType(WxConsts.XML_MSG_TEXT)
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

    /**
     * 处理菜单点击事件
     */
    public static class WxClickMpMessageHandler implements WxMpMessageHandler{
        public WxMpXmlOutMessage handle(WxMpXmlMessage wxMpXmlMessage, Map<String, Object> map, WxMpService wxMpService, WxSessionManager wxSessionManager)
                throws WxErrorException {
            //如果要求返回联系方式
            if(wxMpXmlMessage.getEventKey().equals(Consts.NUMGER_EVENT_ID)){
                WxMpXmlOutTextMessage textMessage = WxMpXmlOutMessage.TEXT()
                        .content("8321-312")
                        .fromUser(wxMpXmlMessage.getToUserName())
                        .toUser(wxMpXmlMessage.getFromUserName())
                        .build();
                return textMessage;
            }//如果需要返回微博
            else if(wxMpXmlMessage.getEventKey().equals(Consts.WEIBO_EVENT_ID)){
                WxMpXmlOutTextMessage textMessage = WxMpXmlOutMessage.TEXT()
                        .content("@rzn")
                        .fromUser(wxMpXmlMessage.getToUserName())
                        .toUser(wxMpXmlMessage.getFromUserName())
                        .build();
                return textMessage;
            }
            return null;
        }
    }

}
