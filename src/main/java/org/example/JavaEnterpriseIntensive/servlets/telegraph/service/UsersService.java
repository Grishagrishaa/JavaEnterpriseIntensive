package org.example.JavaEnterpriseIntensive.servlets.telegraph.service;

import org.example.JavaEnterpriseIntensive.servlets.telegraph.core.dto.User;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class UsersService {
    private static UsersService usersService;

    private Set<User> usersPool = usersPool = new HashSet<>();


    private UsersService() {
        usersPool.add(new User("admin", "admin", "admin", null, null, true ));
    }

    public User findUser(String login, String password){
        for (User user : usersPool) {
            if(user.getLogin().equalsIgnoreCase(login) && user.getPassword().equalsIgnoreCase(password)){
                return user;
            }
        }
        return null;
    }

    public User findUserByLogin(String login){
        for (User user : usersPool) {
            if(user.getLogin().equalsIgnoreCase(login)){
                return user;
            }
        }
        return null;
    }

    public boolean saveUser(User newUser){
        if(findUser(newUser.getLogin(), newUser.getPassword()) == null){
            usersPool.add(newUser);
            return true;
        }else{
            return false;
        }
    }

    public Date formatDate(String dateInString) {
        Date docDate;
        SimpleDateFormat format = new SimpleDateFormat();

        format.applyPattern("dd.MM.yyyy");

        try {
            docDate= format.parse(dateInString);
        } catch (ParseException e) {
            throw new IllegalArgumentException("INCORRECT DATE FORMAT");
        }
        return docDate;
    }

    public static UsersService getInstance(){
        if(usersService == null){
            usersService = new UsersService();
        }
        return usersService;
    }
}
