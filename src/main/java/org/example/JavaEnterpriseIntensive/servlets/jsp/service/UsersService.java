package org.example.JavaEnterpriseIntensive.servlets.jsp.service;

import org.example.JavaEnterpriseIntensive.servlets.jsp.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

public class UsersService {
    private HttpServletRequest req;
    private HttpServletResponse resp;

    public UsersService(HttpServletRequest req, HttpServletResponse resp) {
        this.req = req;
        this.resp = resp;
    }

    public boolean findUser(String login, String password){
        HttpSession session = req.getSession();
        Enumeration<String> attributeNames = session.getAttributeNames();
        while(attributeNames.hasMoreElements()){
            String elementName = attributeNames.nextElement();
            User user = (User) session.getAttribute(elementName);

            if( login.equalsIgnoreCase(user.getLogin()) && password.equalsIgnoreCase(user.getPassword()) ){
                return true;
            }
        }
        return false;
    }
}
