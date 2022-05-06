/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webapps2022.jsf;

import com.webapps2022.ejb.SystemUserService;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author jasonho
 */
@Named
@RequestScoped
public class RegisterAdminBackingBean {

    @EJB
    SystemUserService usrSrv;

    String username;
    String password;
    String name;
    String surname;
    String email;
    String currency;

    public RegisterAdminBackingBean() {

    }

    //call the injected EJB
    public String register() {
        usrSrv.registerSystemUser(username, password, name, surname, email, currency);
        return "login";
    }

    public SystemUserService getUsrSrv() {
        return usrSrv;
    }

    public void setUsrSrv(SystemUserService usrSrv) {
        this.usrSrv = usrSrv;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}
