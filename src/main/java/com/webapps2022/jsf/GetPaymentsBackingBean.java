package com.webapps2022.jsf;

import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.webapps2022.ejb.AccountService;
import com.webapps2022.entity.AcceptedPayments;
import com.webapps2022.entity.Payments;
import com.webapps2022.entity.PendingPayments;
import com.webapps2022.entity.PendingRequests;

@Named
@RequestScoped
public class GetPaymentsBackingBean {

    @EJB
    AccountService acs;
    @Inject
    SystemUserBackingBean user;

    
    private List<PendingPayments> pendingPayments;
    private List<Payments> payments;

    public List<Payments> getPayments() {
        payments = acs.findAllPayments();
        return payments;
    }

    public void setPayments(List<Payments> payments) {
        this.payments = payments;
    }

    public List<PendingRequests> getPendingRequests() {
        return acs.findPendingRequestsByReceiver(user.getUsername());

    }

    public List<PendingPayments> getPendingPayments() {
        System.out.println(acs.findPendingPaymentsByReceiver(user.getUsername()));
        pendingPayments = acs.findPendingPaymentsByReceiver(user.getUsername());
        System.out.println(user.getUsername());
        return pendingPayments;
    }

    public List<AcceptedPayments> getAcceptedPayments() {
        return acs.findAcceptedPaymentsByReceiver(user.getUsername());

    }

    public List<PendingPayments> findthem() {
        List<PendingPayments> pp = acs.findAllPendingPayments();
        System.out.print(pp);
        System.out.println(user.getUsername());
        return pp;
    }

}
