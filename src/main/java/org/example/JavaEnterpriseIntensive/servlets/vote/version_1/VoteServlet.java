package org.example.JavaEnterpriseIntensive.servlets.vote.version_1;

import org.example.JavaEnterpriseIntensive.servlets.vote.version_1.votingSheets.ArtistsListServlet;
import org.example.JavaEnterpriseIntensive.servlets.vote.version_1.votingSheets.GenresListServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "VoteServlet", urlPatterns = "/vote")
public class VoteServlet extends HttpServlet {

    ArtistsListServlet artistsList = new ArtistsListServlet();
    GenresListServlet genresList = new GenresListServlet();


    private final String ARTIST_PARAMETER_HEADER = "ARTIST_NAME_PARAM";//КОНСТАНТА С ИМЕНЕМ ХЕДЕРА, В НЕМ ЗНАЧЕНИЕ ПАРАМЕТРА
    private final String GENRE_PARAMETER_HEADER = "GENRE_NAME_PARAM";//КОНСТАНТА С ИМЕНЕМ ХЕДЕРА, В НЕМ ЗНАЧЕНИЕ ПАРАМЕТРА
    private final String BIO_PARAMETER_HEADER = "BIO_NAME_PARAM";//КОНСТАНТА С ИМЕНЕМ ХЕДЕРА, В НЕМ ЗНАЧЕНИЕ ПАРАМЕТРА


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");//УСТАНОВКА КОДИРОВКИ

        HttpSession session = req.getSession();//ПОЛУНИЕ ТЕКУЩЕЙ СЕССИИ
        PrintWriter writer = resp.getWriter();


        attributeIncrement(session, "participants");//КОЛИЧЕСТВО УЧАСТНИКОВ


        String artistNameParam = req.getHeader(ARTIST_PARAMETER_HEADER);//ПОЛУЧАЕМ НАЗВАНИЕ ПАРАМЕТРА ИЗ ХЕДЕРА, ЧЕРЕЗ КОНСТАНТУ С НАЗВАНИЕМ ХЕДЕРА
        String artist = req.getParameter(artistNameParam);//ПОЛУЧЕМ НАЗВАНИЕ ПАРАМЕТРА

        if (artistsList.getArtistsList().contains(artist)) {//ПРОВЕРЯЕМ НАЛИЧИЕ ЕГО В СПИСКЕ
            attributeIncrement(session, artist);//ЗАСЧИТЫВАЕМ ГОЛОС
        } else {
            writer.write("Нет такого артиста - " + artist);
        }


        String genreNameParam = req.getHeader(GENRE_PARAMETER_HEADER);//ПОЛУЧАЕМ НАЗВАНИЕ ПАРАМЕТРА ИЗ ХЕДЕРА, ЧЕРЕЗ КОНСТАНТУ С НАЗВАНИЕМ ХЕДЕРА
        String[] genres = req.getParameter(genreNameParam).split(",");//ЖАНРОВ МНОГО -> ФОРМИРУЕМ МАССИВ УКАЗАННЫХ ЖАНРОВ
        for (String genre : genres) {//ПРОХОДИМ МАССИВ
            if (genresList.getGenresList().contains(genre)) {//ПРОВЕРЯЕМ НАЛИЧИЕ ЕГО В СПИСКЕ
                attributeIncrement(session, genre);//ЗАСЧИТЫВАЕМ ГОЛОС
            }else{
                writer.println("Нет такого жанра - " + genre);
            }
        }

        String bioNameParam = req.getHeader(BIO_PARAMETER_HEADER);
        if(session.getAttribute("bio") == null){
            session.setAttribute("bio",req.getParameter(bioNameParam));
        }else{
            session.setAttribute("bio",(String) req.getAttribute("bio") + '\n' + req.getParameter(bioNameParam) +'\n');
        }


        writer.println("Голосовавших: " + session.getAttribute("participants"));
        /*Enumeration<String> attributeNames = session.getAttributeNames();

        while(attributeNames.hasMoreElements()){
            String attributeName = attributeNames.nextElement();
            writer.println(attributeName + " " + session.getAttribute(attributeName) + "; ");
        }*/


    }

    private static void attributeIncrement(HttpSession session, String name) {
        if (session.getAttribute(name) == null) {
            session.setAttribute(name, 1);
        } else {
            session.setAttribute(name, (Integer) session.getAttribute(name) + 1);
        }
    }
}
