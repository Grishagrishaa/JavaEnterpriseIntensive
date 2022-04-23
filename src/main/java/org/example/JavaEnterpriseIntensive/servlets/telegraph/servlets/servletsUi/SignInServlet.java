package org.example.JavaEnterpriseIntensive.servlets.telegraph.servlets.servletsUi;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SignInServlet", urlPatterns = "/ui/signIn")
public class SignInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/log.jsp").forward(req, resp);
    }
}
