package com.xmc.controller;

import com.xmc.util.WxUtil;
import me.chanjar.weixin.common.util.StringUtils;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xmc1993 on 16/4/2.
 */
@Controller
@RequestMapping
public class WxController {
    private static final String ECHOSTR = "echostr";

    @RequestMapping({"/", "/*", ""})
    public void wxMegProcesss(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html;charset=utf-8");
        res.setStatus(HttpServletResponse.SC_OK);
        String signature = req.getParameter("signature");
        String nonce = req.getParameter("nonce");
        String timestamp = req.getParameter("timestamp");

        /**
         * 验证该http请求是否来自微信后台 过滤掉非微信后台消息
         */
        if(!WxUtil.isValid(timestamp, nonce, signature)){
            res.getWriter().println("非法请求");
            return;
        }
        //如果是一个仅仅用来验证的请求回显该字符
        String echostr = req.getParameter(ECHOSTR);
        if (StringUtils.isNotBlank(echostr)) {
            res.getWriter().println(echostr);
            return;
        }

        String encryptType = StringUtils.isBlank(req.getParameter("encrypt_type")) ?
                "raw" :
                req.getParameter("encrypt_type");

        if ("raw".equals(encryptType)) {
            // 明文传输的消息
            WxMpXmlMessage inMessage = WxMpXmlMessage.fromXml(req.getInputStream());
            WxMpXmlOutMessage outMessage = WxUtil.getWxMpMessageRouter().route(inMessage);
            res.getWriter().write(outMessage.toXml());
            return;
        }

        if ("aes".equals(encryptType)) {
            // 是aes加密的消息
            String msgSignature = req.getParameter("msg_signature");
            WxMpXmlMessage inMessage = WxMpXmlMessage.fromEncryptedXml(req.getInputStream(), WxUtil.getConfigStorage(), timestamp, nonce, msgSignature);
            WxMpXmlOutMessage outMessage = WxUtil.getWxMpMessageRouter().route(inMessage);
            res.getWriter().write(outMessage.toEncryptedXml(WxUtil.getConfigStorage()));
            return;
        }

        res.getWriter().println("不可识别的加密类型");
        return;

    }
}
