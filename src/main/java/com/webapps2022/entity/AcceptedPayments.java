/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webapps2022.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;

/**
 *
 * @author jasonho
 */


        @NamedQuery(name = "AcceptedPayments.findAll", query = "SELECT a FROM AcceptedPayments a")
        @NamedQuery(name = "AcceptedPayments.findBYSENDER", query = "SELECT a FROM AcceptedPayments a WHERE a.sender_username = ?1")
        @NamedQuery(name = "AcceptedPayments.findBYRECEIVER", query = "SELECT a FROM AcceptedPayments a WHERE a.receiver_username = ?1")

@Entity
public class AcceptedPayments {

    @Id
    private Long id;
    private String receiver_username;
    private String sender_username;
    private double amount;
    private LocalDateTime time_accepted;

    public AcceptedPayments() {
    };

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getTime_accepted() {
        return time_accepted;
    }

    public void setTime_accepted(LocalDateTime time_accepted) {
        this.time_accepted = time_accepted;
    }

    public AcceptedPayments(String sender_username, String receiver_username, double amount) {
        time_accepted = LocalDateTime.now();
        this.receiver_username = receiver_username;
        this.sender_username = sender_username;
        this.amount = amount;
    }
}
