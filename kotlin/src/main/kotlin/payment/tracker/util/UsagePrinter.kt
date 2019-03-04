/*
 * |-------------------------------------------------
 * | Copyright © 2019 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package payment.tracker.util

object UsagePrinter {

    fun printUsage() : Unit {
        println("------------------------")
        println("java -jar PaymentTracker.jar [optional input file]")
        println("------------------------")
    }
}
