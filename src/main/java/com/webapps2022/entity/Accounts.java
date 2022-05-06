/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webapps2022.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.OneToOne;
import javax.persistence.Version;

/**
 *
 * @author jasonho
 */

    @NamedQuery(name = "Accounts.findAll", query = "SELECT a FROM Accounts a")
    @NamedQuery(name = "Accounts.findBYUSER", query = "SELECT a FROM Accounts a WHERE a.username LIKE :username")

@Entity
public class Accounts implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sid")
    private Long sid;
    @OneToOne()
    @MapsId
    @JoinColumn(name = "sid")
    private SystemUsers user;

    private double balance;
    private double pending_balance;
    private String currency;
    private String username;
    @Version
    private Integer version;

    public Accounts() {
    }

    public Long getSid() {
        return sid;
    }

    public void setId(Long sid) {
        this.sid = sid;
    }

    public double getBalance() {
        return balance;
    }

    public SystemUsers getUser() {
        return user;
    }

    public void setUser(SystemUsers user) {
        this.user = user;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getPending_balance() {
        return pending_balance;
    }

    public void setPending_balance(double pending_balance) {
        this.pending_balance = pending_balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Accounts(SystemUsers user, String currency, double balance, double pending_balance, String username) {
        super();
        this.user = user;
        this.balance = balance;
        this.pending_balance = pending_balance;
        this.currency = currency;
        this.username = username;
    }

}
