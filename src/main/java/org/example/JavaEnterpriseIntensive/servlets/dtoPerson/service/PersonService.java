package org.example.JavaEnterpriseIntensive.servlets.dtoPerson.service;

import org.example.JavaEnterpriseIntensive.servlets.dtoPerson.core.dto.Person;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.util.Enumeration;

public class PersonService {
    StringBuilder bld = new StringBuilder();

    CookieService cookServ = new CookieService();
    SessionService senServ = new SessionService();

    private final String NAME_PARAMETER_HEADER = "NAME_PARAM";
    private final String LASTNAME_PARAMETER_HEADER = "LASTNAME_PARAM";
    private final String AGE_PARAMETER_HEADER = "AGE_PARAM";

    public Person createPerson(HttpServletRequest req){

        String nameParam = req.getHeader(NAME_PARAMETER_HEADER);
        String lastnameParam = req.getHeader(LASTNAME_PARAMETER_HEADER);
        String ageParam = req.getHeader(AGE_PARAMETER_HEADER);

        String name = req.getParameter(nameParam);
        String lastname = req.getParameter(lastnameParam);
        int age = Integer.parseInt(req.getParameter(ageParam));

        return new Person(name, lastname, age);
    }

    public void savePerson(Person person, String storageType,HttpServletRequest req ,HttpServletResponse resp){
        if(storageType.equalsIgnoreCase("COOKIE")){
            cookServ.save(person, resp);
        }else if(storageType.equalsIgnoreCase("SESSION")){
            senServ.save(person, req);
        }else {
            throw new IllegalArgumentException("CHECK STORAGE TYPE HEADER");
        }
    }

    public void printPersons(String storageType,HttpServletRequest req ,HttpServletResponse resp) throws IOException {

        PrintWriter writer = resp.getWriter();

        if(storageType.equalsIgnoreCase("COOKIE")){

            Cookie[] cookies = req.getCookies();
            for (Cookie cookie : cookies) {
                try{
                    String[] personValues = cookie.getValue().split("\\|");//[name, lastname, age]
                    bld.append(new Person
                                    (
                                            personValues[0],
                                            personValues[1],
                                            Integer.parseInt(personValues[2])
                                    ))
                            .append('\n');

                }catch (ArrayIndexOutOfBoundsException error){}
            }
            writer.println(bld.toString());
            bld.setLength(0);

        }else if(storageType.equalsIgnoreCase("SESSION")){

            HttpSession session = req.getSession();
            Enumeration<String> attributeNames = session.getAttributeNames();

            while(attributeNames.hasMoreElements()){
                String attributeName = attributeNames.nextElement();

                Person personFromAttribute = (Person) session.getAttribute(attributeName);
                bld.append(personFromAttribute.toString()).append('\n');
            }

            writer.println(bld.toString());
            bld.setLength(0);

        }else {
            throw new IllegalArgumentException("CHECK STORAGE TYPE HEADER");
        }

    }
}
