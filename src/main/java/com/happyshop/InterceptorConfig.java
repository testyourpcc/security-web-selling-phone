package com.happyshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.happyshop.interceptor.AuthorizeInterceptor;
import com.happyshop.interceptor.ShareInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    ShareInterceptor shareInterceptor;

    @Autowired
    AuthorizeInterceptor authorizeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(shareInterceptor).addPathPatterns("/**");

        registry.addInterceptor(authorizeInterceptor).addPathPatterns(
                "/account/change",
                "/order/checkout",
                "/account/logout",
                "/account/edit",
                "/order/list",
                "/order/items",
                "/order/detail",
                "/account/order/**");
    }
}
