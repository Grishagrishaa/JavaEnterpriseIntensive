package org.example.JavaEnterpriseIntensive.servlets.sessions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionService {

    public String readValues(HttpServletRequest req, String PARAMETER_HEADER){
        HttpSession session = req.getSession();

        String param = req.getHeader(PARAMETER_HEADER);

        String value = req.getParameter(param);


        if(value != null && !"".equalsIgnoreCase(value)){
            session.setAttribute(param, value);
            return value;
        }else{
            String valueFromSession = (String) session.getAttribute(param);
            if(valueFromSession == null /*&& "".equalsIgnoreCase(valueFromSession)*/){
                throw new RuntimeException("handled");
            }
            return valueFromSession;
        }
    }
}
