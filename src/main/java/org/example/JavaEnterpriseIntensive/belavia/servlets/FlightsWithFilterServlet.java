package org.example.JavaEnterpriseIntensive.belavia.servlets;

import org.example.JavaEnterpriseIntensive.belavia.dao.FlightsDao;
import org.example.JavaEnterpriseIntensive.belavia.dto.FlightsDto;
import org.example.JavaEnterpriseIntensive.belavia.service.FlightService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.List;

@WebServlet(name = "FlightsWithFilterServlet", urlPatterns = "/flightsWithFilter")
public class FlightsWithFilterServlet extends HttpServlet {
    FlightService service = new FlightService();
    int begin = 0;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String startDate = req.getParameter("startDate");
        String departureAirPort = req.getParameter("departureAirPort");
        String arrivalDate = req.getParameter("arrivalDate");
        String arrivalAirPort = req.getParameter("arrivalAirPort");

        List<FlightsDto> filteredFlightsList = service.getFlightsList(startDate, departureAirPort,
                                                              arrivalDate, arrivalAirPort);
        String path = req.getContextPath();

        getServletContext().setAttribute("allFlights",filteredFlightsList );


        if(req.getParameter("Next") != null){
            begin += 25;
        }else if (req.getParameter("Back") != null){
            begin -= 25;
        } else if (req.getParameter("Cancel") != null) {
            resp.sendRedirect(path + "/flights");
            begin = 0;
        } else{
            begin = 0;
        }

        getServletContext().setAttribute("begin", begin);
        getServletContext().setAttribute("end", begin + 24);

        req.getRequestDispatcher("belavia/Content.jsp").forward(req, resp);

    }
}
