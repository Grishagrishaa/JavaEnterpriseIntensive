package org.example.JavaEnterpriseIntensive.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


@WebServlet(name = "Filter", urlPatterns = "/Filter")
public class FilterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        StringBuilder bld = new StringBuilder();

        Enumeration<String> params = req.getParameterNames();

        while(params.hasMoreElements()){
           String param= params.nextElement();
           String paramValue = req.getParameter(param);
            //boolean flag = false;
            for (int i = 0; i < paramValue.length() ; i++) {
                if (Character.isDigit(paramValue.charAt(i))){
                    break;
                }
                if(i==param.length()-1){
                    bld.append(paramValue).append(" ");
                }
            }

        }
        writer.write(bld.toString());

    }
}
