package org.example.JavaEnterpriseIntensive.servlets.vote.version_2.servlets;

import org.example.JavaEnterpriseIntensive.servlets.vote.version_2.comparators.MyValueComparator;
import org.example.JavaEnterpriseIntensive.servlets.vote.version_2.service.VoteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "TopGenresServlet", urlPatterns = "/topGenres")
public class TopGenresServlet extends HttpServlet {
    VoteService vService = VoteService.getInstance();

    Map<String, Integer> topGenres = vService.getTopGenres();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = resp.getWriter();

        List list = new ArrayList(topGenres.entrySet());
        list.sort(new MyValueComparator().reversed());

        for (int i = 0; i < list.size() ; i++) {
            writer.println("<p>" +  (i+1) + ": " + list.get(i) + " - проголосовавших" + "</p>" );
        }
    }
}
