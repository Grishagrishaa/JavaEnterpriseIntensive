package org.example.JavaEnterpriseIntensive.servlets.jsp.servlets;

import org.example.JavaEnterpriseIntensive.servlets.jsp.service.UsersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LogServlet", urlPatterns = "/api/login")
public class LogServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsersService usServ = new UsersService(req, resp);
        PrintWriter writer = resp.getWriter();

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if(usServ.findUser(login, password)){
            writer.println("aboba");
        }else{
            throw new IllegalAccessError("INCORRECT PASSWORD");
        }
    }
}
