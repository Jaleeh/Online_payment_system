/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webapps2022.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;

/**
 *
 * @author jasonho
 */

        @NamedQuery(name = "RequestPayments.findAll", query = "SELECT a FROM RequestPayments a")
        @NamedQuery(name = "RequestPayments.findBYSENDER", query = "SELECT a FROM RequestPayments a WHERE a.sender_username = ?1")
        @NamedQuery(name = "RequestPayments.findBYRECEIVER", query = "SELECT a FROM RequestPayments a WHERE a.receiver_username = ?1")

@Entity
public class RequestPayments implements Serializable {

    public RequestPayments() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Accounts receiver;
    @ManyToOne
    private Accounts sender;
    private String sender_username;
    private String receiver_username;
    private double amount;

    public double getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Accounts getReceiver() {
        return receiver;
    }

    public void setReceiver(Accounts receiver) {
        this.receiver = receiver;
    }

    public Accounts getSender() {
        return sender;
    }

    public void setSender(Accounts sender) {
        this.sender = sender;
    }

    public String getReceiver_username() {
        return receiver_username;
    }

    public void setReceiver_username(String receiver_username) {
        this.receiver_username = receiver_username;
    }

    public String getSender_username() {
        return sender_username;
    }

    public void setSender_username(String sender_username) {
        this.sender_username = sender_username;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public RequestPayments(Accounts sender, Accounts receiver, double amount, String receiver_username,
            String sender_username) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.receiver_username = receiver_username;
        this.sender_username = sender_username;

    }

}
