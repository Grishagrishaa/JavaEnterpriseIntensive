package org.example.JavaEnterpriseIntensive.servlets.vote.version_2.servlets;

import org.example.JavaEnterpriseIntensive.servlets.vote.version_2.core.dto.VoteDto;
import org.example.JavaEnterpriseIntensive.servlets.vote.version_2.service.VoteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "VoteServlet", urlPatterns = "/vote")
public class VoteServlet extends HttpServlet {
    private final String ARTIST_PARAMETER_HEADER = "ARTIST_NAME_PARAM";//КОНСТАНТА С ИМЕНЕМ ХЕДЕРА, В НЕМ ЗНАЧЕНИЕ ПАРАМЕТРА(В ХЕДЕРЕ)
    private final String GENRE_PARAMETER_HEADER = "GENRE_NAME_PARAM";//КОНСТАНТА С ИМЕНЕМ ХЕДЕРА, В НЕМ ЗНАЧЕНИЕ ПАРАМЕТРА
    private final String BIO_PARAMETER_HEADER = "BIO_NAME_PARAM";//КОНСТАНТА С ИМЕНЕМ ХЕДЕРА, В НЕМ ЗНАЧЕНИЕ ПАРАМЕТРА

    VoteDto voteList;

    VoteService vService = VoteService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String artistParam = req.getHeader(ARTIST_PARAMETER_HEADER);
        String genreParam = req.getHeader(GENRE_PARAMETER_HEADER);
        String bioParam = req.getHeader(BIO_PARAMETER_HEADER);

        int artistValue = Integer.parseInt(req.getParameter(artistParam));
        int[] genreValues = vService.stringToInt(req.getParameter(genreParam).split(","));
        String bioValue = req.getParameter(bioParam);

        voteList = new VoteDto(artistValue, genreValues, bioValue);

        vService.save(voteList);

    }
}
