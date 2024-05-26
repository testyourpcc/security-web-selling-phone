package com.happyshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.happyshop.interceptor.AuthorizeInterceptorAdmin;
import com.happyshop.interceptor.ShareInterceptor;

@Configuration
public class InterceptorConfigAdmin implements WebMvcConfigurer {

    @Autowired
    ShareInterceptor shareInterceptor;

    @Autowired
    AuthorizeInterceptorAdmin authorizeInterceptorAdmin;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(shareInterceptor).addPathPatterns("/**");

        registry.addInterceptor(authorizeInterceptorAdmin).addPathPatterns(
                "/admin/home/index",
                "/admin/product/index",
                "/admin/category/index",
                "/admin/inventory/index",
                "/admin/profile",
                "/admin/customer/index",
                "/admin/order/index",
                "/admin/report/inventory",
                "/admin/revenue/category",
                "/admin/revenue/customer",
                "/admin/revenue/month",
                "/admin/revenue/quarter",
                "/admin/change",
                "/admin/revenue/year",
                "/admin/report/revenue-by-category",
                "/admin/report/revenue-by-customer",
                "/admin/report/revenue-by-month",
                "/admin/report/revenue-by-quarter",
                "/admin/report/revenue-by-year");
    }
}
