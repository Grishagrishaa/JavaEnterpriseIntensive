package org.example.JavaEnterpriseIntensive.belavia.servlets;

import org.example.JavaEnterpriseIntensive.belavia.dao.FlightsDao;
import org.example.JavaEnterpriseIntensive.belavia.dto.FlightsDto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FlightsServlet", value = "/flights")
public class FlightsServlet extends HttpServlet {
    FlightsDao dao = new FlightsDao();
    private int begin = 0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<FlightsDto> allFlights = dao.getAll();
        try {
            dao.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        getServletContext().setAttribute("allFlights", allFlights);

        getServletContext().setAttribute("begin", 0);
        getServletContext().setAttribute("end", 24);

        request.getRequestDispatcher("belavia/Content.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getParameter("Next") != null){
            begin+=25;
        }
        if(request.getParameter("Back") != null){
            if(begin>24){
                begin-=25;
            }else{
                begin=0;
            }
        }
        if(request.getParameter("Cancel") != null){
            begin=0;
        }
        getServletContext().setAttribute("begin", begin);
        getServletContext().setAttribute("end", begin + 24);

        request.getRequestDispatcher("belavia/Content.jsp").forward(request, response);
    }
}
