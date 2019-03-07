/*
 * |-------------------------------------------------
 * | Copyright © 2019 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package payment.tracker

import payment.tracker.model.CurrencyCode
import java.math.BigDecimal

class Parser {

    private val paymentListing : PaymentListing = PaymentListing(HashMap())

    fun invoke(input : String) {
        val lineItems = input.split(" ")
        val currencyCode = CurrencyCode.valueOf(lineItems[0])
        val amount = BigDecimal(lineItems[1])
        paymentListing.addPayment(currencyCode, amount)
    }
}
