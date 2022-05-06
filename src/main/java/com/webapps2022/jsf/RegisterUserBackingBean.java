/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webapps2022.jsf;

import com.webapps2022.ejb.SystemUserService;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author jasonho
 */
@Named
@RequestScoped
public class RegisterUserBackingBean {

    @EJB
    SystemUserService usrSrv;

    String username;
    String password;
    String name;
    String surname;

    String email;
    String currency;

    public RegisterUserBackingBean() {

    }

    //call the injected EJB
    public String register() {
           if (currency.equals("EUR") || currency.equals("USD") || currency.equals("GBP")) {
                usrSrv.registerSystemUser(username, password, name, surname, email, currency.toUpperCase());
                return "login";
            } else {
                FacesContext.getCurrentInstance().addMessage("register",
                        new FacesMessage("Please choose the right currency"));    
        }
        return "error";
    }
public String registerAdmin() {
           if (currency.equals("EUR") || currency.equals("USD") || currency.equals("GBP")) {
                usrSrv.registerSystemAdmin(username, password, name, surname, email, currency.toUpperCase());
                return "login";
            } else {
                FacesContext.getCurrentInstance().addMessage("register",
                        new FacesMessage("Please choose the right currency"));    
        }
        return "error";
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
