package org.example.JavaEnterpriseIntensive.servlets.dtoPerson.service;

import org.example.JavaEnterpriseIntensive.servlets.dtoPerson.core.dto.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Random;

public class SessionService {

    public void save(Person person, HttpServletRequest req ){

        HttpSession session = req.getSession();

        session.setAttribute(String.valueOf(person.hashCode()), person);
    }
}
