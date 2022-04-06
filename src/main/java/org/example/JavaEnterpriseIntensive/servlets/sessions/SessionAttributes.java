package org.example.JavaEnterpriseIntensive.servlets.sessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SessionAtributes", urlPatterns = "/sessionVote")
public class SessionAttributes extends HttpServlet {

    private final String FIRSTNAME_PARAMETER_HEADER = "FNAME_PARAM";
    private final String LASTNAME_PARAMETER_HEADER = "LNAME_PARAM";

    SessionService service = new SessionService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        String name = service.readValues(req, FIRSTNAME_PARAMETER_HEADER);

        String lastName = service.readValues(req, LASTNAME_PARAMETER_HEADER);

        writer.println("Hello, " + name + " " + lastName);

    }
}
