/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webapps2022.ejb;

import com.webapps2022.entity.Accounts;
import com.webapps2022.entity.SystemUserGroup;
import com.webapps2022.entity.SystemUsers;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author jasonho
 */
@Stateless
public class SystemUserService {

    @PersistenceContext
    EntityManager em;
    EntityManagerFactory emf;

    public SystemUserService() {
        this.emf = Persistence.createEntityManagerFactory("WebappsDBPU");
        this.em = this.emf.createEntityManager();
    }

    public void registerSystemUser(String username, String password, String name, String surname, String email,
            String currency) {
        try {
            SystemUsers user;
            SystemUserGroup user_group;
            Accounts account;

            MessageDigest md = MessageDigest.getInstance("SHA-256");
            String passwd = password;
            md.update(passwd.getBytes("UTF-8"));
            byte[] digest = md.digest();
            BigInteger bigInt = new BigInteger(1, digest);
            String paswdToStoreInDB = bigInt.toString(16);

            user = new SystemUsers(username, paswdToStoreInDB, name, surname, email);
            user_group = new SystemUserGroup(username, "users");
            account = new Accounts();
            account.setUsername(username);
            account.setUser(user);
            account.setCurrency(currency);
            account.setBalance(initialBalance(currency));
            account.setPending_balance(initialBalance(currency));

            em.persist(user);
            em.persist(user_group);
            em.persist(account);

        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            Logger.getLogger(SystemUserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void registerSystemAdmin(String username, String password, String name, String surname, String email,
            String currency) {
        try {
            SystemUsers user;
            SystemUserGroup user_group;
            Accounts account;

            MessageDigest md = MessageDigest.getInstance("SHA-256");
            String passwd = password;
            md.update(passwd.getBytes("UTF-8"));
            byte[] digest = md.digest();
            BigInteger bigInt = new BigInteger(1, digest);
            String paswdToStoreInDB = bigInt.toString(16);

            user = new SystemUsers(username, paswdToStoreInDB, name, surname, email);
            user_group = new SystemUserGroup(username, "admins");
            account = new Accounts();
            account.setUser(user);
            account.setUsername(username);
            account.setCurrency(currency);
            account.setBalance(initialBalance(currency));
            account.setPending_balance(initialBalance(currency));

            em.persist(user);
            em.persist(user_group);
            em.persist(account);

        } catch (UnsupportedEncodingException | NoSuchAlgorithmException ex) {
            Logger.getLogger(SystemUserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public double initialBalance(String cur) {
        double init_bal = 1000;
        if (cur.equals("USD")) {
            init_bal = init_bal * 1.29;
        } else if (cur.equals("EUR")) {
            init_bal = init_bal * 1.19;
        }
        return init_bal;
    }

    public SystemUsers findSystemUser(String username) {
        SystemUsers user = em.createQuery(
                "SELECT u from SystemUsers u WHERE u.username = :username", SystemUsers.class)
                .setParameter("username", username).getSingleResult();
        return user;
    }

    public List<SystemUsers> findAllUsers() {
        TypedQuery<SystemUsers> query = em.createQuery("select c from SystemUsers c",
                SystemUsers.class);
        return query.getResultList();
    }

    public void registerSystemUser(String username, String password, String name, String surname, String email) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
