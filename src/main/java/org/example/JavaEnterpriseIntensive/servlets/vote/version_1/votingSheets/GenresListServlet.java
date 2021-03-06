package org.example.JavaEnterpriseIntensive.servlets.vote.version_1.votingSheets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "GenresListServlet", urlPatterns = "/Genres")
public class GenresListServlet extends HttpServlet {

    private String genresList =
                    "Поп-музыка\n" +
                    "Классическая музыка\n" +
                    "Рок\n" +
                    "Блюз\n" +
                    "Ритм-н-блюз (R’n’B)\n" +
                    "Блюз\n" +
                    "Шансон\n" +
                    "Электро\n" +
                    "Хип-хоп\n" +
                    "Метал";

    public String getGenresList() {
        return genresList;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter().write(genresList);
    }
}
