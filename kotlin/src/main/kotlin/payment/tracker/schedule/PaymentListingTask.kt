/*
 * |-------------------------------------------------
 * | Copyright © 2019 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package payment.tracker.schedule

import payment.tracker.Parser
import payment.tracker.model.CurrencyCode
import payment.tracker.model.MoneyAmount

class PaymentListingTask(private val parser: Parser) {

    fun schedulePaymentListings() {
        val paymentAmounts : MutableMap<CurrencyCode, MoneyAmount> = parser.paymentListing.paymentAmounts
        for ((key, value) in paymentAmounts.entries) {
            println("$key $value")
        }
    }
}
