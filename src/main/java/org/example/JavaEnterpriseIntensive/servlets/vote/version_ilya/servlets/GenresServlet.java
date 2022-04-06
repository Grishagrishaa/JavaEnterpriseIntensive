package org.example.JavaEnterpriseIntensive.servlets.vote.version_ilya.servlets;


import org.example.JavaEnterpriseIntensive.servlets.vote.version_ilya.service.GenreService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

//@WebServlet(name = "GenresServlet", urlPatterns = "/vote/genre")
public class GenresServlet extends HttpServlet {

    private GenreService service;

    public GenresServlet() {
        this.service = GenreService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();

        List<String> genres = service.getGenres();

        int index = 1;
        for (String genre : genres) {
            writer.write("<p>" + index++ + " - " + genre + "</p></br>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        service.add(req.getParameter("genre"));
    }
}
