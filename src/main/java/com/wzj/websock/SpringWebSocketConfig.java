package com.wzj.websock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;


@Configuration
@EnableWebMvc
@EnableWebSocket
public class SpringWebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer {
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        System.out.println("==========================注册socket"); System.out.println("==========================注册socket");
        //注册websocket server实现类，"/webSocketServer"访问websocket的地址
        registry.addHandler(webSocketHandler(),"/websocket/socketServer").setAllowedOrigins("*").addInterceptors(new SpringWebSocketHandlerInterceptor());
        //使用socketjs的注册方法
        registry.addHandler(webSocketHandler(), "/sockjs/socketServer").setAllowedOrigins("*").addInterceptors(new SpringWebSocketHandlerInterceptor()).withSockJS();
    }

    @Bean
    public TextWebSocketHandler webSocketHandler(){
        return new SpringWebSocketHandler();
    }

}