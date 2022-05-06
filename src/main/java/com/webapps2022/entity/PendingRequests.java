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

        @NamedQuery(name = "PendingRequests.findAll", query = "SELECT a FROM PendingRequests a")
        @NamedQuery(name = "PendingRequests.findBYSENDER", query = "SELECT a FROM PendingRequests a WHERE a.sender_username = ?1")
        @NamedQuery(name = "PendingRequests.findBYRECEIVER", query = "SELECT a FROM PendingRequests a WHERE a.receiver_username = ?1")
@Entity
public class PendingRequests implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long request_id;
    private String receiver_username;
    private String sender_username;
    private double amount;
    private LocalDateTime time_sent;

    public PendingRequests() {
    };

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRequest_id() {
        return request_id;
    }

    public void setRequest_id(Long request_id) {
        this.request_id = request_id;
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

    public LocalDateTime getTime_sent() {
        return time_sent;
    }

    public void setTime_sent(LocalDateTime time_sent) {
        this.time_sent = time_sent;
    }

    public PendingRequests(String sender_username, String receiver_username, double amount) {
        time_sent = LocalDateTime.now();
        this.sender_username = sender_username;
        this.receiver_username = receiver_username;
        this.amount = amount;

    }
}
