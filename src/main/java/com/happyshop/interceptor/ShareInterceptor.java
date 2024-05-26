package com.happyshop.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.happyshop.dao.CategoryDAO;
import com.happyshop.dao.UserDAO;
import com.happyshop.entity.Category;
import com.happyshop.entity.User;

@Component
public class ShareInterceptor implements HandlerInterceptor {
    
    @Autowired
    private CategoryDAO categoryDAO;
    
    @Autowired
    private UserDAO userDAO;
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        if (modelAndView != null) {
            List<Category> categories = categoryDAO.findAll();
            modelAndView.addObject("cates", categories);
            
            List<User> users = userDAO.findAll();
            modelAndView.addObject("users", users);
        }
    }
}
