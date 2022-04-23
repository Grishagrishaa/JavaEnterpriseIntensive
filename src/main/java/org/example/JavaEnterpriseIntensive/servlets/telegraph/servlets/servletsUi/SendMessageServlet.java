package org.example.JavaEnterpriseIntensive.servlets.telegraph.servlets.servletsUi;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SmsServlet", value = "/ui/user/message")
public class SendMessageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/message.jsp").forward(request, response);
    }
}
