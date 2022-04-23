package org.example.JavaEnterpriseIntensive.telegraph.core.dto;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class User {
    private String login;
    private String password;
    private String fullName;
    private Date BirthDate;
    private LocalDateTime RegistrationDate;
    private Boolean isAdmin;

    public User() {
    }


    public User(String login, String password, String fullName, Date birthDate, LocalDateTime registrationDate, Boolean isAdmin) {
        this.login = login;
        this.password = password;
        this.fullName = fullName;
        BirthDate = birthDate;
        RegistrationDate = registrationDate;
        this.isAdmin = isAdmin;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public Date getBirthDate() {
        return BirthDate;
    }

    public LocalDateTime getRegistrationDate() {
        return RegistrationDate;
    }

    public Boolean getAdminStatus() {
        return isAdmin;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) && Objects.equals(password, user.password)
                && Objects.equals(fullName, user.fullName) && Objects.equals(BirthDate, user.BirthDate)
                && Objects.equals(RegistrationDate, user.RegistrationDate) && Objects.equals(isAdmin, user.isAdmin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, fullName, BirthDate, RegistrationDate, isAdmin);
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\n' +
                "fullName='" + fullName + '\n' +
                "BirthDate=" + BirthDate + '\n' +
                "RegistrationDate=" + RegistrationDate + '\n' +
                "isAdmin=" + isAdmin +
                '}';
    }
}
