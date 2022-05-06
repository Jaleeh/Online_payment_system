/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webapps2022.jsf;

import com.webapps2022.ejb.AccountService;
import com.webapps2022.ejb.SystemUserService;
import com.webapps2022.entity.Accounts;
import com.webapps2022.entity.SystemUsers;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author jasonho
 */
@Named
@SessionScoped
public class FindAccountBackingBean implements Serializable {

    @EJB
    SystemUserService sysUsrSrvs;
    @EJB
    AccountService accSrv;
    private Accounts receiver;
    private String username;
    private String receiver_username;

    public SystemUserService getSysUsrSrvs() {
        return sysUsrSrvs;
    }

    public void setSysUsrSrvs(SystemUserService sysUsrSrvs) {
        this.sysUsrSrvs = sysUsrSrvs;
    }

    public AccountService getPaySrv() {
        return accSrv;
    }

    public void setPaySrv(AccountService accSrv) {
        this.accSrv = accSrv;
    }

    public String getReceiver_username() {
        return receiver_username;
    }

    public void setReceiver_username(String receiver_username) {
        this.receiver_username = receiver_username;
    }

    public Accounts getReceiver() {
        return receiver;
    }

    public void setReceiver(Accounts receiver) {
        this.receiver = receiver;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void findReceiverAccount() {
        try {

            SystemUsers foundAccount = sysUsrSrvs.findSystemUser(username);
            Accounts receiver_id = accSrv.findAccount(foundAccount.getSid());
            setReceiver(receiver_id);
            setReceiver_username(foundAccount.getSurname());

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("paymentForm:sender",
                    new FacesMessage("User not registered"));
        }

    }
}
