/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webapps2022.ejb;

import com.webapps2022.entity.AcceptedPayments;
import com.webapps2022.entity.Accounts;
import com.webapps2022.entity.PendingPayments;
import com.webapps2022.entity.PendingRequests;
import com.webapps2022.entity.RequestPayments;
import com.webapps2022.entity.Payments;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jasonho
 */
@Stateless
public class AccountService {
        @PersistenceContext
        EntityManager em;

        public AccountService() {
        }

        @SuppressWarnings("unchecked")
        public List<AcceptedPayments> findAllAcceptedPayments() {
                Query q = em.createNamedQuery("AcceptedPayments.findAll");
                return q.getResultList();
        }

        @SuppressWarnings("unchecked")

        public List<AcceptedPayments> findAcceptedPaymentsBySender(String sender_username) {
                Query q = em.createNamedQuery("AcceptedPayments.findBYSENDER").setParameter(1, sender_username);
                return q.getResultList();

        }

        @SuppressWarnings("unchecked")

        public List<AcceptedPayments> findAcceptedPaymentsByReceiver(String receiver_username) {
                Query q = em.createNamedQuery("AcceptedPayments.findAll").setParameter(1, receiver_username);
                return q.getResultList();
        }

        public Accounts findAccount(Long id) {
                Accounts account = em.find(Accounts.class, id);
                return account;
        }

        @SuppressWarnings("unchecked")
        public List<Accounts> findAllAccounts() {
                Query q = em.createNamedQuery("Accounts.findAll");
                return q.getResultList();
        }

        @SuppressWarnings("unchecked")

        public List<Payments> findAllPayments() {
                Query q = em.createNamedQuery("Payments.findAll");
                return q.getResultList();
        }

        @SuppressWarnings("unchecked")

        public List<Payments> findPaymentsBySender(String sender_username) {
                Query q = em.createNamedQuery("Payments.findBYSENDER").setParameter("sender_username", sender_username);
                return q.getResultList();
        }

        public List<Payments> findPaymentsByReceiver(String receiver_username) {
                Query q = em.createNamedQuery("Payments.findBYRECEIVER").setParameter(1, receiver_username);
                return q.getResultList();
        }

        @SuppressWarnings("unchecked")

        public List<PendingPayments> findAllPendingPayments() {
                Query q = em.createNamedQuery("PendingPayments.findAll");
                return q.getResultList();
        }

        public List<PendingPayments> findPendingPaymentsBySender(String sender_username) {
                Query q = em.createNamedQuery("PendingPayments.findBYSENDER").setParameter(1, sender_username);
                return q.getResultList();
        }

        public List<PendingPayments> findPendingPaymentsByReceiver(String receiver_username) {
                Query q = em.createNamedQuery("PendingPayments.findBYRECEIVER").setParameter(1, receiver_username);
                return q.getResultList();
        }

        public List<PendingRequests> findAllPendingRequests() {
                Query q = em.createNamedQuery("PendingRequests.findAll");
                return q.getResultList();
        }

        public List<PendingRequests> findPendingRequestsBySender(String sender_username) {
                Query q = em.createNamedQuery("PendingRequests.findBYSENDER").setParameter(1, sender_username);
                return q.getResultList();
        }

        @SuppressWarnings("unchecked")

        public List<PendingRequests> findPendingRequestsByReceiver(String receiver_username) {
                Query q = em.createNamedQuery("PendingRequests.findBYRECEIVER").setParameter(1, receiver_username);
                return q.getResultList();
        }

        @SuppressWarnings("unchecked")

        public List<RequestPayments> findAllRequestPayments() {
                Query q = em.createNamedQuery("RequestPayments.findAll");
                return q.getResultList();
        }

        @SuppressWarnings("unchecked")

        public List<RequestPayments> findRequestPaymentsBySender(String sender_username) {
                Query q = em.createNamedQuery("RequestPayments.findBYSENDER").setParameter(1, sender_username);
                return q.getResultList();
        }

        @SuppressWarnings("unchecked")

        public List<RequestPayments> findRequestPaymentsByReceiver(String receiver_username) {
                Query q = em.createNamedQuery("RequestPayments.findBYRECEIVER").setParameter(1, receiver_username);
                return q.getResultList();
        }
}
