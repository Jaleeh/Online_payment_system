/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webapps2022.jsf;

import com.webapps2022.ejb.AccountService;
import com.webapps2022.ejb.PaymentsService;
import com.webapps2022.ejb.SystemUserService;
import com.webapps2022.entity.Accounts;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author jasonho
 */
@Named
@RequestScoped
public class PaymentsBackingBean {

    @EJB
    SystemUserService sysUsrSrvs;
    @EJB
    PaymentsService paySrvs;
    @EJB
    AccountService accSrvs;
    @Inject
    FindAccountBackingBean receiverBackingBean;
    @Inject
    SystemUserBackingBean senderBackingBean;
    private Accounts sender;
    private String username;
    private Accounts receiver;
    private double amount;

    public SystemUserService getSysUsrSrvs() {
        return sysUsrSrvs;
    }

    public void setSysUsrSrvs(SystemUserService sysUsrSrvs) {
        this.sysUsrSrvs = sysUsrSrvs;
    }

    public PaymentsService getPaySrvs() {
        return paySrvs;
    }

    public void setPaySrvs(PaymentsService paySrvs) {
        this.paySrvs = paySrvs;
    }

    public AccountService getAccSrv() {
        return accSrvs;
    }

    public void setAccSrv(AccountService accSrv) {
        this.accSrvs = accSrv;
    }

    public FindAccountBackingBean getReceiverBean() {
        return receiverBackingBean;
    }

    public void setReceiverBean(FindAccountBackingBean receiverBean) {
        this.receiverBackingBean = receiverBean;
    }

    public Accounts getSender() {
        return sender;
    }

    public void setSender(Accounts sender) {
        this.sender = sender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Accounts getReceiver() {
        return receiver;
    }

    public void setReceiver(Accounts receiver) {
        this.receiver = receiver;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String makePayment() {
        setSender(senderBackingBean.findUserAccount());
        setReceiver(receiverBackingBean.getReceiver());
        double sender_balance = sender.getBalance();
        if (sender_balance < amount) {
            FacesContext.getCurrentInstance().addMessage("payment_form:price",
                    new FacesMessage("Insufficient funds"));
            return "error";
        } else {
            paySrvs.makePayment(sender, receiver, amount);

        }
        return "users";

    }

    public void acceptPayment(Long id) {
        paySrvs.acceptPayment(id);
    }

    public void rejectPayment(Long id) {
        paySrvs.rejectPayment(id);
    }

    public void acceptRequest(Long id) {
        paySrvs.acceptRequest(id);
    }

    public void acceptedRequest(Long id) {
        paySrvs.rejectRequest(id);
    }
}
