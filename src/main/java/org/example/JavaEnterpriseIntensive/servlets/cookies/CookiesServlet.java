package org.example.JavaEnterpriseIntensive.servlets.cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "CookiesServlet", urlPatterns = "/cookies")
public class CookiesServlet extends HttpServlet {
    Cookie myCookie;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        String parameter1 = "firstName";
        String parameter2 = "lastName";

        if(req.getParameter(parameter1) != null){
            myCookie = new Cookie(parameter1,req.getParameter(parameter1));
            resp.addCookie(myCookie);
        }else{
            Cookie[] cookies = req.getCookies();
            if(cookies == null) throw new ServletException("check cookies or parameters");

        }

        if(req.getParameter(parameter2) != null){
            myCookie = new Cookie(parameter2,req.getParameter(parameter2));
            resp.addCookie(myCookie);
        }else{
            Cookie[] cookies = req.getCookies();
            if(cookies == null) throw new ServletException("check cookies or parameters");

        }



        Cookie[] cookies = req.getCookies();
        if(cookies == null) throw new ServletException("check cookies or parameters");
        for (Cookie cookie : cookies) {
            if("".equalsIgnoreCase(cookie.getValue()))return;
            writer.println("Hello, " + cookie.getValue());
        }
    }
}
