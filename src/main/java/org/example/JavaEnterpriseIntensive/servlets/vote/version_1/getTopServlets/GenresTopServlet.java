package org.example.JavaEnterpriseIntensive.servlets.vote.version_1.getTopServlets;

import org.example.JavaEnterpriseIntensive.servlets.vote.version_1.comparators.MyValueComparator;
import org.example.JavaEnterpriseIntensive.servlets.vote.version_1.votingSheets.GenresListServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

//@WebServlet(name = "GenresTopServlet", urlPatterns = "/topGenres")

public class GenresTopServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");


        GenresListServlet genresList = new GenresListServlet();
        PrintWriter writer = resp.getWriter();

        HttpSession session = req.getSession();
        Enumeration<String> attributeNames = session.getAttributeNames();

        HashMap<String, Integer> map = new HashMap();

        while(attributeNames.hasMoreElements()){
            String attributeName = attributeNames.nextElement();
            if (genresList.getGenresList().contains(attributeName)){
                map.put(attributeName, (Integer) session.getAttribute(attributeName));
            }
        }

        writer.println("Итоги голосования:");

        List list = new ArrayList(map.entrySet());
        list.sort(new MyValueComparator().reversed());

        for (int i = 0; i < list.size() ; i++) {
            writer.println(i + 1 + " место: " + list.get(i) + " за него!");
        }
    }
}
