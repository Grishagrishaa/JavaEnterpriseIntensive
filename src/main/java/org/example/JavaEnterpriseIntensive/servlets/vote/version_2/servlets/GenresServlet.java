package org.example.JavaEnterpriseIntensive.servlets.vote.version_2.servlets;

import org.example.JavaEnterpriseIntensive.servlets.vote.version_2.service.GenreService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "GenresServlet", urlPatterns = "/genres")
public class GenresServlet extends HttpServlet {

    GenreService genService = GenreService.getInstance();

    private final String GENRE_PARAMETER_HEADER = "GENRE_NAME_PARAM";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        List<String> genList = genService.getGenList();

        for (int i = 0; i <genList.size() ; i++) {
            writer.println("<p>" + (i+1) + ": " + genList.get(i) + "</p>" );
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String genreHeader = req.getHeader(GENRE_PARAMETER_HEADER);
        genService.add(req.getParameter(genreHeader));
    }
}
