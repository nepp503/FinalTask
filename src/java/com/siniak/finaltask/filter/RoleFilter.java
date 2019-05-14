package com.siniak.finaltask.filter;

import com.siniak.finaltask.entity.User;
import com.siniak.finaltask.entity.type.UserType;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "/controller", servletNames = "Controller")
public class RoleFilter implements Filter {
    private static final String USER_ATTR = "user";

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        System.out.println("filter");
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        User user = (User) httpServletRequest.getSession().getAttribute(USER_ATTR);
        if (user == null || user.getUserType() == null) {
            user = new User();
            user.setUserType(UserType.GUEST);
            httpServletRequest.getSession().setAttribute(USER_ATTR, user);
        }
        filterChain.doFilter(request, response);
    }

    public void destroy() {
    }
}
