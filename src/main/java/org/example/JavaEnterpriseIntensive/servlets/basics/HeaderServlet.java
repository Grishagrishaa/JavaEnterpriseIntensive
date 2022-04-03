package org.example.JavaEnterpriseIntensive.servlets.basics;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


@WebServlet(name = "Headers", urlPatterns = "/getHeaders")
public class HeaderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        StringBuilder bld = new StringBuilder();

        Enumeration<String> headerNames = req.getHeaderNames();

        while(headerNames.hasMoreElements()){
           String headerName = headerNames.nextElement();
           String headerValue = req.getHeader(headerName);
           bld.append(headerName).append(" :").append(headerValue).append(". ").append('\n');

        }
        writer.write(bld.toString());

    }
}
