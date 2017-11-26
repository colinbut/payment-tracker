/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.pt;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PaymentListing {

    private static PaymentListing INSTANCE = new PaymentListing();

    private Map<Currency, MoneyAmount> paymentAmounts = new HashMap<>();

    public static PaymentListing getInstance() {
        return INSTANCE;
    }

    public Map<Currency, MoneyAmount> getPaymentAmounts() {
        return paymentAmounts;
    }

    public void addPayment(Currency currency, BigDecimal amount) {
        if (paymentAmounts.get(currency) != null) {
            MoneyAmount existingPaymentAmount = paymentAmounts.get(currency);
            existingPaymentAmount.setAmount(existingPaymentAmount.getAmount().add(amount));
        }
        paymentAmounts.put(currency, new MoneyAmount(currency, amount));
    }
}
