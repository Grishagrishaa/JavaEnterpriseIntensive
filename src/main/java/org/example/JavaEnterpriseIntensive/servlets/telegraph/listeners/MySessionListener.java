package org.example.JavaEnterpriseIntensive.servlets.telegraph.listeners;

import org.example.JavaEnterpriseIntensive.servlets.telegraph.service.StatisticService;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class MySessionListener implements HttpSessionAttributeListener {

StatisticService stats = StatisticService.getInstance();

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        if(event.getSession().getAttribute("user") != null){
            stats.usersCountIncrement();
            System.out.println("USERRRRRRRRRRRRRRRRR");
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        stats.usersCountDecrement();
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {

    }
}
