/*
 * |-------------------------------------------------
 * | Copyright © 2019 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package payment.tracker

import payment.tracker.model.CurrencyCode
import payment.tracker.model.MoneyAmount
import java.math.BigDecimal

class PaymentListing (val paymentAmounts : MutableMap<CurrencyCode, MoneyAmount>) {

    fun addPayment(currencyCode: CurrencyCode, amount: BigDecimal) {
        if (paymentAmounts.get(currencyCode) != null) {
            val existingPayment : MoneyAmount = paymentAmounts.get(currencyCode)!!
            existingPayment.amount = existingPayment.amount.add(amount)
        } else {
            paymentAmounts.putIfAbsent(currencyCode, MoneyAmount(currencyCode, amount))
        }
    }
}
