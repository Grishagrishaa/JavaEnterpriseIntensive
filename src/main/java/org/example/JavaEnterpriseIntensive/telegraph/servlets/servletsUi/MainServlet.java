package org.example.JavaEnterpriseIntensive.telegraph.servlets.servletsUi;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MainServlet", value = "/ui")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("MainPage.jsp").forward(request, response);
    }
}
