package org.example.JavaEnterpriseIntensive.servlets.vote.votingSheets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ArtistsListServlet", urlPatterns = "/Artists")
public class ArtistsListServlet extends HttpServlet {

    private String artistsList =
                    "Боярский Михаил\n" +
                    "Голубые гитары ВИА\n" +
                    "Добрынин Александр\n" +
                    "Представитель группы ЛЕС";

    public String getArtistsList() {
        return artistsList;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter().write(artistsList);
    }
}
