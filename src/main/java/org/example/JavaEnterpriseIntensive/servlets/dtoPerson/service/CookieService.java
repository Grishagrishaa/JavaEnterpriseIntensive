package org.example.JavaEnterpriseIntensive.servlets.dtoPerson.service;

import org.example.JavaEnterpriseIntensive.servlets.cookies.CookiesServlet;
import org.example.JavaEnterpriseIntensive.servlets.dtoPerson.core.dto.Person;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.ObjectOutputStream;

public class CookieService {
    private StringBuilder bld = new StringBuilder();

    public void save (Person person, HttpServletResponse resp){
            bld.
                append(person.getName()).append("|").
                append(person.getLastName()).append("|").
                append(String.valueOf(person.getAge()))/*.append("|")*/;

        Cookie myCookie = new Cookie(String.valueOf(person.hashCode()), bld.toString());

        bld.setLength(0);

        resp.addCookie(myCookie);
    }
}
