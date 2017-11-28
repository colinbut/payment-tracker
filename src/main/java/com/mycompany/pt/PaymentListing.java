/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.pt;

import com.mycompany.pt.model.CurrencyCode;
import com.mycompany.pt.model.MoneyAmount;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PaymentListing {

    private static PaymentListing INSTANCE = new PaymentListing();

    private Map<CurrencyCode, MoneyAmount> paymentAmounts = new HashMap<>();

    public static PaymentListing getInstance() {
        return INSTANCE;
    }

    public Map<CurrencyCode, MoneyAmount> getPaymentAmounts() {
        return paymentAmounts;
    }

    public void addPayment(CurrencyCode currencyCode, BigDecimal amount) {
        if (paymentAmounts.get(currencyCode) != null) {
            MoneyAmount existingPaymentAmount = paymentAmounts.get(currencyCode);
            existingPaymentAmount.setAmount(existingPaymentAmount.getAmount().add(amount));
        } else {
            paymentAmounts.put(currencyCode, new MoneyAmount(currencyCode, amount));
        }
    }
}
