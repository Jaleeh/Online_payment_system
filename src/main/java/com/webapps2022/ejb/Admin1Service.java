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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
/**
 *
 * @author jasonho
 */
@Singleton
@Startup
public class Admin1Service {

    @PersistenceContext
    EntityManager em;
    EntityManagerFactory emf;

    @PostConstruct
    public void init() {
        try {
            String username = "admin1";
            String password = "admin1";
            String name = "admin1";
            String surname = "admin1";
            String email = "admin1@admin1.admin";
            String currency = "GBP";
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

    public double initialBalance(String cur) {
        double init_bal = 1000;
        if (cur.equals("USD")) {
            init_bal = init_bal * 1.29;
        } else if (cur.equals("EUR")) {
            init_bal = init_bal * 1.19;
        }
        return init_bal;
    }

}
