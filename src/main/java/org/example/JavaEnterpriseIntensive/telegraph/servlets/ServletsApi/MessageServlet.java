package org.example.JavaEnterpriseIntensive.telegraph.servlets.ServletsApi;

import org.example.JavaEnterpriseIntensive.telegraph.core.dto.Message;
import org.example.JavaEnterpriseIntensive.telegraph.core.dto.User;
import org.example.JavaEnterpriseIntensive.telegraph.service.MessageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(name = "MessageServlet", urlPatterns = "/api/message")
public class MessageServlet extends HttpServlet {
    MessageService sms = new MessageService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        User user = (User) req.getSession().getAttribute("user");
        List<Message> messageBox = sms.getMessageBox(user);

        req.getSession().setAttribute("messageBox", messageBox);
        req.getRequestDispatcher("/smsBox.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String recipient = req.getParameter("recipient");
        String message = req.getParameter("sms");
        sms.sendMessage(req,recipient,message);
        req.getSession().setAttribute("smsmessage", "SMS WAS SENT");
        resp.sendRedirect(req.getContextPath() +"/ui/user/message");
    }
}
