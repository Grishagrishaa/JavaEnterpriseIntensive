package org.example.JavaEnterpriseIntensive.servlets.telegraph.servlets.ServletsApi;

import org.example.JavaEnterpriseIntensive.servlets.telegraph.core.dto.StatsDto;
import org.example.JavaEnterpriseIntensive.servlets.telegraph.service.StatisticService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet(name = "StatsServletApi", value = "/api/admin/stats")//не работает нихуя урл этот ебаный
public class StatsServletApi extends HttpServlet {
    StatisticService stats = StatisticService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int usersCount =  stats.getUsersCount().intValue();

        int messagesCount = stats.getMessagesCount().intValue();

        StatsDto stats = new StatsDto(usersCount, messagesCount);

        req.getSession().setAttribute("StatsData", stats);

        req.getRequestDispatcher("/stats.jsp").forward(req, resp);
    }
}
