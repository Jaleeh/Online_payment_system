/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.webapps2022.entity;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
/**
 *
 * @author jasonho
 */
@Entity
public class SystemUsers implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sid;

    @NotNull    
    @Column(unique = true)

    private String username;
    @NotNull
    private String password;
    @NotNull
    private String name;
    @NotNull
    private String surname;

    @Column(unique = true)
    private String email;

    public SystemUsers() {
    }

    public SystemUsers(String username, String password, String name, String surname, String email) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.surname = surname;

    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.sid);
        hash = 47 * hash + Objects.hashCode(this.username);
        hash = 47 * hash + Objects.hashCode(this.surname);
        hash = 47 * hash + Objects.hashCode(this.name);
        hash = 47 * hash + Objects.hashCode(this.email);

        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SystemUsers other = (SystemUsers) obj;
        if (!Objects.equals(this.sid, other.sid)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.surname, other.surname)) {
            return false;
        }
        return true;
    }

}
