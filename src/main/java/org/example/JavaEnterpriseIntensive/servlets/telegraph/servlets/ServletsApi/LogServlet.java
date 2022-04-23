package org.example.JavaEnterpriseIntensive.servlets.telegraph.servlets.ServletsApi;

import org.example.JavaEnterpriseIntensive.servlets.telegraph.core.dto.User;
import org.example.JavaEnterpriseIntensive.servlets.telegraph.service.UsersService;

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
        UsersService usServ = UsersService.getInstance();
        PrintWriter writer = resp.getWriter();

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        User user = usServ.findUser(login, password);

        if(user != null){
            req.getSession().setAttribute("user", user);
            writer.println("SUCCESSFUL SIGN IN");
            String contextPath = req.getContextPath();
            resp.sendRedirect( contextPath + "/ui/user/message");
        }else{
            writer.println("INCORRECT INPUT DATA");
        }
    }
}
