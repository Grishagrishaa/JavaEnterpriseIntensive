package org.example.JavaEnterpriseIntensive.servlets.dtoPerson.servlets;

import org.example.JavaEnterpriseIntensive.servlets.dtoPerson.core.dto.Person;
import org.example.JavaEnterpriseIntensive.servlets.dtoPerson.service.PersonService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CreatePersonServlet", urlPatterns = "/Person")
public class PersonServlet extends HttpServlet {
    /*STORAGE TYPE HEADER = STORAGE*/

    PersonService service = new PersonService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String storageType = req.getHeader("STORAGE");

        Person person = service.createPerson(req);

        service.savePerson(person, storageType, req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String storageType = req.getHeader("STORAGE");

        service.printPersons(storageType, req, resp);
    }
}
