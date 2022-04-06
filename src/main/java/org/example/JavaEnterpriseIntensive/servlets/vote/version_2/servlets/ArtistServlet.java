package org.example.JavaEnterpriseIntensive.servlets.vote.version_2.servlets;

import org.example.JavaEnterpriseIntensive.servlets.vote.version_2.service.ArtistService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ArtistServlet", urlPatterns = "/artists")
public class ArtistServlet extends HttpServlet {

    private final String ARTIST_PARAMETER_HEADER =  "ARTIST_NAME_PARAM";

    private ArtistService arService = ArtistService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();


        List<String> arList = arService.getArtists();


        for (int i = 0; i <arList.size() ; i++) {
            writer.println("<p>" + (i+1) + ": " + arList.get(i) + "</p>"  );
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String artistHeader = req.getHeader(ARTIST_PARAMETER_HEADER);
        arService.add(req.getParameter(artistHeader));
    }
}
