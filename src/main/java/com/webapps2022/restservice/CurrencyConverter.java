/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webapps2022.restservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 *
 * @author jasonho
 */
@Path("/conversion")
@Produces(APPLICATION_JSON)
public class CurrencyConverter {

    @GET
    @Path("{currency1}/{currency2}/{amount_of_currency1}")
    public double hi(@PathParam("currency1") String currency1, @PathParam("currency2") String currency2,
            @PathParam("amount_of_currency1") double amount) {
        if (currency1.equals("EUR") && currency2.equals("USD")) {
            double new_amount = eur_usd(amount);
            return new_amount;
        }
        if (currency1.equals("USD") && currency2.equals("EUR")) {
            double new_amount = usd_eur(amount);
            return new_amount;
        }
        if (currency1.equals("EUR") && currency2.equals("GBP")) {
            double new_amount = eur_gbp(amount);
            return new_amount;
        }
        if (currency1.equals("GBP") && currency2.equals("EUR")) {
            double new_amount = gbp_eur(amount);
            return new_amount;
        }
        if (currency1.equals("GBP") && currency2.equals("USD")) {
            double new_amount = gbp_usd(amount);
            return new_amount;
        }
        if (currency1.equals("USD") && currency2.equals("GBP")) {
            double new_amount = usd_gbp(amount);
            return new_amount;
        }

        return 1;
    }

    public double eur_usd(double amount) {
        return amount * 1.05;
    };

    public double usd_eur(double amount) {
        return amount * 0.95;
    };

    public double eur_gbp(double amount) {
        return amount * 0.84;
    };

    public double gbp_usd(double amount) {
        return amount * 1.25;
    };

    public double gbp_eur(double amount) {
        return amount * 1.19;
    };

    public double usd_gbp(double amount) {
        return amount * 0.8;
    };
}

