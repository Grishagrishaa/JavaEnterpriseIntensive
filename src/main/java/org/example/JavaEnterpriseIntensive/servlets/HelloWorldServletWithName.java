package org.example.JavaEnterpriseIntensive.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloWorldServletWithName", urlPatterns = "/hello_with_name")
public class HelloWorldServletWithName extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF=8");

        String firstname = req.getParameter("firstname");

        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = resp.getWriter();
        writer.write("<p><span style='color: blue;'>Hello " + firstname + "!</span></p>" );
    }
}
//PrintWriter writer = resp.getWriter();
// writer.write("ACCESS TO THIS INTERNET RESOURCE IS LIMITED\n" +
//         "“Access to the resource is limited in pursuance of the decision of the Ministry of Information of the Republic of Belarus, " +
//         "adopted on the basis of the Law of the Republic of Belarus “On Mass Media”.\n" +
//         "\"Access to the resource is limited on the basis of paragraph 11 of the Regulations " +
//         "on the procedure for restricting access to information resources (their components) located on the global computer network Internet.\"");
//