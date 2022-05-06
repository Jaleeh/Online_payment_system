/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webapps2022.jsf;

import com.webapps2022.ejb.AccountService;
import com.webapps2022.ejb.PaymentsService;
import com.webapps2022.ejb.SystemUserService;
import com.webapps2022.entity.Accounts;
import com.webapps2022.entity.SystemUsers;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author jasonho
 */
@Named
@SessionScoped
public class SystemUserBackingBean implements Serializable {

    @EJB
    SystemUserService sysUsrSrvs;
    @EJB
    PaymentsService pySrvs;
    @EJB
    AccountService accSrvs;
    private SystemUsers sender;
    private String username;
    private SystemUsers user;

    public SystemUserService getSysUsrSrvs() {
        return sysUsrSrvs;
    }

    public void setSysUsrSrvs(SystemUserService sysUsrSrvs) {
        this.sysUsrSrvs = sysUsrSrvs;
    }

    public SystemUsers getUser() {
        String principal_name = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
        SystemUsers user = sysUsrSrvs.findSystemUser(principal_name);
        return user;
    }

    public void setUser(SystemUsers user) {
        this.user = user;
    }

    public SystemUserService getsysUsrSrvs() {
        return sysUsrSrvs;
    }

    public void setsysUsrSrvs(SystemUserService sysUsrSrvs) {
        this.sysUsrSrvs = sysUsrSrvs;
    }

    public SystemUsers getSender() {
        sender = sysUsrSrvs.findSystemUser(username);
        return sender;
    }

    public void setSender(SystemUsers sender) {
        this.sender = sender;
    }

    public String getUsername() {
        String username = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();

        // username = sysUsrSrvs.findSystemUser(principal_name).getUsername();
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void findSystemUser() {
        SystemUsers usr = sysUsrSrvs.findSystemUser(username);
        if (null != usr) {
            setUsername(usr.getSurname());
        }
    }

    public Accounts findUserAccount() {
        String name = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
        Long id = sysUsrSrvs.findSystemUser(name).getSid();
        Accounts account = accSrvs.findAccount(id);
        return account;
    }

}
