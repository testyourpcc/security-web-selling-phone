package com.happyshop.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import com.happyshop.entity.User;

@Component
public class AuthorizeInterceptor implements HandlerInterceptor {
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user == null) {
            session.setAttribute("back-url", request.getRequestURI());
            response.sendRedirect("/account/login");
            return false;
        } else if (user.getAdmin()) {
            // Nếu không phải là admin, chuyển hướng hoặc xử lý logic khi không có quyền truy cập
        	 request.getRequestDispatcher("/WEB-INF/views/error/forbidden.jsp").forward(request, response);
            return false;
        }
        return true;
    }
}
