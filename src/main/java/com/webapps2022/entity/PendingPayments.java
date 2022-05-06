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
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;

/**
 *
 * @author jasonho
 */

        @NamedQuery(name = "PendingPayments.findAll", query = "SELECT a FROM PendingPayments a")
        @NamedQuery(name = "PendingPayments.findBYSENDER", query = "SELECT a FROM PendingPayments a WHERE a.sender_username = ?1")
        @NamedQuery(name = "PendingPayments.findBYRECEIVER", query = "SELECT a FROM PendingPayments a WHERE a.receiver_username = ?1")

@Entity
public class PendingPayments implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long payment_id;
    private String receiver_username;
    private String sender_username;
    private double amount;
    private LocalDateTime time_sent;

    public PendingPayments() {
    };

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(Long payment_id) {
        this.payment_id = payment_id;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getTime_sent() {
        return time_sent;
    }

    public void setTime_sent(LocalDateTime time_sent) {
        this.time_sent = time_sent;
    }

    public PendingPayments(String sender_username, double amount, String receiver_username, Long payment_id) {
        time_sent = LocalDateTime.now();
        this.sender_username = sender_username;
        this.amount = amount;
        this.receiver_username = receiver_username;
        this.payment_id = payment_id;

    }
}
