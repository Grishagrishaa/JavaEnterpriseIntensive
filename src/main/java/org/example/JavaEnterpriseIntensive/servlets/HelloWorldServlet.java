package org.example.JavaEnterpriseIntensive.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorldServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.getWriter().append("<title>ACCESS TO THIS INTERNET RESOURCE IS LIMITED</title>")
                .append("<body>")
                .append("<img src=\"https://stat2.city-dog.by/content/editor_images/2022/03_march/08_28295/439137bee3c929c317b51a310a69c126.jpg\">")
                .append("</body>");
    }
}
//PrintWriter writer = resp.getWriter();
// writer.write("ACCESS TO THIS INTERNET RESOURCE IS LIMITED\n" +
//         "“Access to the resource is limited in pursuance of the decision of the Ministry of Information of the Republic of Belarus, " +
//         "adopted on the basis of the Law of the Republic of Belarus “On Mass Media”.\n" +
//         "\"Access to the resource is limited on the basis of paragraph 11 of the Regulations " +
//         "on the procedure for restricting access to information resources (their components) located on the global computer network Internet.\"");
//