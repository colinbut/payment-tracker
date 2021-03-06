/*
 * |-------------------------------------------------
 * | Copyright © 2019 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package payment.tracker

import payment.tracker.model.CurrencyCode
import payment.tracker.model.MoneyAmount
import java.math.BigDecimal

// TODO convert to Singleton
class PaymentListing (val paymentAmounts : MutableMap<CurrencyCode, MoneyAmount>) {

    fun addPayment(currencyCode: CurrencyCode, amount: BigDecimal) {
        if (paymentAmounts[currencyCode] != null) {
            val existingPayment : MoneyAmount = paymentAmounts[currencyCode]!!
            existingPayment.amount = existingPayment.amount.add(amount)
        } else {
            paymentAmounts.putIfAbsent(currencyCode, MoneyAmount(currencyCode, amount))
        }
    }
}
