/*
 * |-------------------------------------------------
 * | Copyright © 2019 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package payment.tracker.schedule

import payment.tracker.parser
import java.util.*
import kotlin.concurrent.scheduleAtFixedRate

class PaymentScheduler {

    private val paymentListingTask : PaymentListingTask = PaymentListingTask(parser)

    fun schedulePaymentListing() {
        val timer = Timer("schedule", true)
        timer.scheduleAtFixedRate(1000, 60000) {
            paymentListingTask.schedulePaymentListings()
        }
    }

}
