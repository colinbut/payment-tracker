/*
 * |-------------------------------------------------
 * | Copyright © 2019 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package payment.tracker

import payment.tracker.model.CurrencyCode
import java.lang.RuntimeException
import java.math.BigDecimal

class Parser {

    private val paymentListing : PaymentListing = PaymentListing(HashMap())

    fun invoke(input : String) {
        val lineItems = input.split(" ")
        if (lineItems.size != 2) {
            throw RuntimeException("Invalid arguments entered, expecting format [CurrencyCode Amount]")
        }

        if (lineItems[0] == "" || lineItems[1] == "") {
            throw RuntimeException("Invalid arguments entered, expecting format [CurrencyCode Amount]")
        }

        val currencyCode = CurrencyCode.valueOf(lineItems[0])
        val amount = BigDecimal(lineItems[1])

        paymentListing.addPayment(currencyCode, amount)
    }
}
