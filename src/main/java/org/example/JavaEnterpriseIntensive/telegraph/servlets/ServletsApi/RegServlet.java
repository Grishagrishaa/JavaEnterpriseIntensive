package org.example.JavaEnterpriseIntensive.telegraph.servlets.ServletsApi;

import org.example.JavaEnterpriseIntensive.telegraph.core.dto.User;
import org.example.JavaEnterpriseIntensive.telegraph.service.UsersService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

@WebServlet(name = "RegServlet", value = "/api/user")
public class RegServlet extends HttpServlet {

    public RegServlet() {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsersService usServ = UsersService.getInstance();
        PrintWriter writer = resp.getWriter();


        String login = req.getParameter("login");
        String password = req.getParameter("password");

        String fullName = req.getParameter("fullName");
        String BirthDate = req.getParameter("birthDate");

        String contextPath = req.getContextPath();

        User user = new User(login, password, fullName, usServ.formatDate(BirthDate), LocalDateTime.now(), false );
        if(usServ.saveUser(user)){
            /*writer.println("Successful sign up".toUpperCase());*/
            req.getSession().setAttribute("message", "YOU HAVE BEEN SIGNED UP, JUST LOG IN NOW ");
            resp.sendRedirect(contextPath + "/ui/signIn");
        }else{
            req.getSession().setAttribute("message", "user with this login already exists".toUpperCase());
            resp.sendRedirect(contextPath + "/ui/signup");
        }
    }
}
