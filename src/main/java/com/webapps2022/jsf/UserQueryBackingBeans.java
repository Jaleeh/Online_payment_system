package com.webapps2022.jsf;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
// import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.webapps2022.ejb.AccountService;
import com.webapps2022.entity.Payments;

@Named
@SessionScoped
public class UserQueryBackingBeans implements Serializable {
    @EJB
    AccountService acs;
    @Inject
    SystemUserBackingBean user;

    private List<Payments> payments;

    public List<Payments> getPayments() {
        payments = acs.findAllPayments();
        System.out.println(payments);
        return payments;
    }

    public void setPayments(List<Payments> payments) {
        this.payments = payments;
    }
}
