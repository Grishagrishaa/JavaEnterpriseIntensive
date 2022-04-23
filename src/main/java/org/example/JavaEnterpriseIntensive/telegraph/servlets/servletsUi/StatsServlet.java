package org.example.JavaEnterpriseIntensive.telegraph.servlets.servletsUi;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "StatsServlet", value = "/ui/admin/stats")
public class StatsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/api/admin/stats").forward(request, response);
    }


}
