/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.pt;

import com.mycompany.pt.model.CurrencyCode;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Parser {

    private static PaymentListing paymentListing = PaymentListing.getInstance();

    private static final Parser INSTANCE = new Parser();

    public static Parser getInstance() {
        return INSTANCE;
    }

    public void invoke(String input) {
        String[] lineItems = input.split(" ");
        CurrencyCode currencyCode = CurrencyCode.valueOf(lineItems[0]);
        BigDecimal amount = new BigDecimal(lineItems[1]);
        paymentListing.addPayment(currencyCode, amount);
    }
}
