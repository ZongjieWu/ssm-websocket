package com.wzj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wzj.websock.SpringWebSocketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.socket.TextMessage;


@Controller
public class WebsocketController {
    @Bean//这个注解会从Spring容器拿出Bean
    public SpringWebSocketHandler infoHandler() {
        return new SpringWebSocketHandler();
    }

    @RequestMapping("loginPage")
    public String loginPage() {
        return "WEB-INF/views/login";
    }

    @RequestMapping("login")
    public String login(String username,HttpSession session) throws Exception {
        System.out.println(username+"登录");
        session.setAttribute("SESSION_USERNAME", username);
        return "WEB-INF/views/websocket/chat";
    }

    @RequestMapping("send")
    @ResponseBody
    public String send(HttpServletRequest request,String username) {
        System.out.println("发送消息给username"+username);
        System.out.println("发送消息给username"+username);
        System.out.println("发送消息给username"+username);
        //给某人发消息
        infoHandler().sendMessageToUser(username, new TextMessage("你好，测试！！！！"));
        return null;
    }
    @RequestMapping("sendAll")
    @ResponseBody
    public String sendAll(HttpServletRequest request,String username) {
        System.out.println("发送消息给usernameAll");
        System.out.println("发送消息给usernameAll");
        //给某人发消息
        infoHandler().sendMessageToUsers(new TextMessage("我是帅哥,我就是吴宗杰哦"));
        return null;
    }
}