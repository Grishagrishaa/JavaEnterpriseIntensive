package org.example.JavaEnterpriseIntensive.servlets.vote.version_2.servlets;

import org.example.JavaEnterpriseIntensive.servlets.vote.version_2.service.VoteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "BioServlet", urlPatterns = "/bio")
public class BioServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = resp.getWriter();

        VoteService serv = VoteService.getInstance();

        List<String> bioList = serv.getBioList();

        for (int i = 0; i < bioList.size() ; i++) {
            writer.println("<p>" + (i+1) + ": " + bioList.get(i) + "</p>");
        }
    }
}
