package org.example.JavaEnterpriseIntensive.servlets.jsp.servlets;

import org.example.JavaEnterpriseIntensive.servlets.jsp.User;
import org.example.JavaEnterpriseIntensive.servlets.jsp.service.UsersService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Date;

@WebServlet(name = "RegServlet", value = "/api/user")
public class RegServlet extends HttpServlet {

    SimpleDateFormat format = new SimpleDateFormat();


    public RegServlet() {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsersService usServ = new UsersService(request, response);
        PrintWriter writer = response.getWriter();
        format.applyPattern("dd.MM.yyyy");


        String login = request.getParameter("login");
        String password = request.getParameter("password");

        String fullName = request.getParameter("fullName");
        String BirthDate = request.getParameter("BirthDate");

        Date docDate;
        try {
            docDate= format.parse(BirthDate);
        } catch (ParseException e) {
            throw new IllegalAccessError();
        }


        if(usServ.findUser(login,password)){
            writer.println("User with same access info already exists");
            response.sendRedirect("/api/login");
        } else{
            User user = new User(login, password, fullName, docDate, LocalDateTime.now(), false );
            request.getSession().setAttribute("user", user);
            /*String.valueOf(user.hashCode())*/
        }

    }
}
