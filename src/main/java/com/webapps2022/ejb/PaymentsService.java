/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webapps2022.ejb;

import com.webapps2022.entity.AcceptedPayments;
import com.webapps2022.entity.Accounts;
import com.webapps2022.entity.Payments;
import com.webapps2022.entity.PendingPayments;
import com.webapps2022.entity.RequestPayments;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jasonho
 */
@Stateless
public class PaymentsService {

        @PersistenceContext
        EntityManager em;

        public PaymentsService() {
        }

        public Payments findPayment(Long id) {
                return em.find(Payments.class, id);
        }

        public void makePayment(Accounts sender, Accounts receiver, double amount) {
                Payments payments;
                PendingPayments pending_payment;
                Accounts new_sender = sender;
                Accounts new_receiver = receiver;
                payments = new Payments(sender, receiver, amount, new_sender.getUsername(), new_receiver.getUsername());
                double sender_pending_balance = new_sender.getPending_balance();
                double receiver_pending_balance = new_receiver.getPending_balance();
                Long payment_id = payments.getId();
                PendingPayments new_pending_transfers = new PendingPayments(sender.getUser().getUsername(), amount,
                                receiver.getUser().getUsername(), payment_id);
                new_sender.setPending_balance(sender_pending_balance - amount);
                new_receiver.setPending_balance(amount + receiver_pending_balance);
                pending_payment = new PendingPayments();
                payments.setStatus("pending");
                pending_payment.setPayment_id(payment_id);
                em.persist(payments);
                em.merge(new_sender);
                em.merge(new_receiver);
                em.persist(new_pending_transfers);

        }

        public void acceptPayment(Long id) {
                Payments payments = findPayment(id);
                AcceptedPayments accepted_payment;
                Accounts new_sender = payments.getSender();
                Accounts new_receiver = payments.getReceiver();
                new_sender.setBalance(new_sender.getPending_balance());
                new_receiver.setBalance(new_receiver.getPending_balance());
                accepted_payment = new AcceptedPayments(new_sender.getUsername(), new_receiver.getUsername(),
                                payments.getAmount());
                payments.setStatus("accepted");
                em.merge(payments);
                em.persist(accepted_payment);
        };

        public void rejectPayment(Long id) {
                PendingPayments pending_payments;
                pending_payments = em.find(PendingPayments.class, id);
                Payments payments = findPayment(pending_payments.getPayment_id());
                payments.setStatus("rejected");
                em.merge(payments);
                em.remove(pending_payments);
        };

        public void makeRequest(Accounts sender, Accounts receiver, double amount) {
                RequestPayments request;
                request = new RequestPayments(sender, receiver, amount, sender.getUsername(), receiver.getUsername());
                em.persist(request);

        };

        public void acceptRequest(Long id) {
                RequestPayments request;
                request = em.find(RequestPayments.class, id);
                Accounts sender = request.getReceiver();
                Accounts receiver = request.getSender();
                double amount = request.getAmount();
                String sender_username = sender.getUser().getUsername();
                String receiver_username = receiver.getUser().getUsername();
                Payments payment = new Payments(sender, receiver, amount, sender.getUsername(), receiver.getUsername());
                payment.setReceiver_username(receiver_username);
                payment.setSender_username(sender_username);
                payment.setStatus("accepted");
                sender.setBalance(sender.getPending_balance() - amount);
                sender.setPending_balance(sender.getPending_balance() - amount);
                receiver.setBalance(receiver.getBalance() + amount);
                receiver.setPending_balance(receiver.getBalance() + amount);
                em.persist(payment);
                em.remove(request);

        };

        public void rejectRequest(Long id) {
                RequestPayments request;
                request = em.find(RequestPayments.class, id);
                em.remove(request);
        };

}