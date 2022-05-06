/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webapps2022.jsf;

import com.webapps2022.ejb.AccountService;
import com.webapps2022.ejb.PaymentsService;
import com.webapps2022.ejb.SystemUserService;
import com.webapps2022.entity.Accounts;
import com.webapps2022.entity.Payments;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author jasonho
 */
@Named
@RequestScoped

public class AdminBackingBean {

    @EJB
    SystemUserService sysUsrSrvs;
    @EJB
    PaymentsService pySrvs;
    @EJB
    AccountService accSrvs;
    private List<Payments> payments;
    private List<Accounts> accounts;

    public List<Payments> getPayments() {
        payments = accSrvs.findAllPayments();
        return payments;
    }

    public void setPayments(List<Payments> payments) {
        this.payments = payments;
    }

    public List<Accounts> getAccounts() {
        accounts = accSrvs.findAllAccounts();
        return accounts;
    }

    public void setAccounts(List<Accounts> accounts) {
        this.accounts = accounts;
    }

}
