package org.example.JavaEnterpriseIntensive.servlets.telegraph.Filters;

import org.example.JavaEnterpriseIntensive.servlets.telegraph.core.dto.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/ui/admin/*", "/api/admin/*"})
public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String contextPath = req.getContextPath();
        HttpSession session = req.getSession();
        if ((session != null) && (session.getAttribute("user") != null)) {
            User user = (User) session.getAttribute("user");
            if(user.getAdminStatus()){
                chain.doFilter(request, response);
            }else {
                res.sendRedirect(contextPath + "/ui");
            }

        }else {
            res.sendRedirect(contextPath + "/ui");
        }
    }

    @Override
    public void destroy() {

    }
}
