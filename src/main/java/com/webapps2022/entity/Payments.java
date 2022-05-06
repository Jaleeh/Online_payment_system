/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webapps2022.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
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


        @NamedQuery(name = "Payments.findAll", query = "SELECT a FROM Payments a")
        @NamedQuery(name = "Payments.findBYSENDER", query = "SELECT a FROM Payments a WHERE a.sender_username = :sender_username")
        @NamedQuery(name = "Payments.findBYRECEIVER", query = "SELECT a FROM Payments a WHERE a.receiver_username = ?1")
@Entity
public class Payments implements Serializable {

    public Payments() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Accounts sender;
    @ManyToOne
    private Accounts receiver;
    private LocalDateTime thrift_timestamp;
    private double amount;
    private String status;
    private String receiver_username;
    private String sender_username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Accounts getSender() {
        return sender;
    }

    public void setSender(Accounts sender) {
        this.sender = sender;
    }

    public Accounts getReceiver() {
        return receiver;
    }

    public void setReceiver(Accounts receiver) {
        this.receiver = receiver;
    }

    public LocalDateTime getThrift_timestamp() {
        return thrift_timestamp;
    }

    public void setThrift_timestamp(LocalDateTime thrift_timestamp) {
        this.thrift_timestamp = thrift_timestamp;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime gettimestamp() {
        return thrift_timestamp;
    }

    public String getSender_username() {
        return sender_username;
    }

    public void setSender_username(String sender_username) {
        this.sender_username = sender_username;
    }

    public String getReceiver_username() {
        return receiver_username;
    }

    public void setReceiver_username(String receiver_username) {
        this.receiver_username = receiver_username;
    }

    public Payments(Accounts sender, Accounts receiver, double amount, String sender_username,
            String receiver_username) {
        thrift_timestamp = LocalDateTime.now();
        this.sender_username = sender_username;
        this.receiver_username = receiver_username;
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
    }

}
