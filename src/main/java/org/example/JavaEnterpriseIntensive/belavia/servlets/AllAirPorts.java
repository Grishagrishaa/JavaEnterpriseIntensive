package org.example.JavaEnterpriseIntensive.belavia.servlets;

import org.example.JavaEnterpriseIntensive.belavia.dto.AirPortDto;
import org.example.JavaEnterpriseIntensive.belavia.dao.AirPortDao;
import org.example.JavaEnterpriseIntensive.belavia.dao.IAirPortDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AllAirPorts", value = "/airports")
public class AllAirPorts extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        IAirPortDao service = new AirPortDao();
        List<AirPortDto> allAirPortDtos = service.getAll();

        try {
            service.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        getServletContext().setAttribute("allAirPorts", allAirPortDtos);

        request.getRequestDispatcher("/belavia/Airports.jsp").forward(request, response);
    }
}
