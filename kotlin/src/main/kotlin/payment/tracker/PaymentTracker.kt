package payment.tracker

import payment.tracker.io.PaymentTrackerReader
import payment.tracker.schedule.PaymentScheduler
import payment.tracker.util.UsagePrinter
import java.lang.IllegalArgumentException
import java.util.*
import kotlin.collections.HashMap
import kotlin.concurrent.scheduleAtFixedRate

fun main(args: Array<String>) {

    val paymentListing = PaymentListing(HashMap())
    val parser = Parser(paymentListing)
    val paymentScheduler = PaymentScheduler(parser)

    val timer = Timer("schedule", true)
    timer.scheduleAtFixedRate(1000, 60000) {
        paymentScheduler.schedulePaymentListings()
    }

    if (args.size > 1) {
        UsagePrinter.printUsage()
        throw IllegalArgumentException("Invalid number of arguments")
    }

    if (args.size == 1){
        val optionalInputFile = args[0]
        PaymentTrackerReader.readInputFile(optionalInputFile)
                .forEach { line -> parser.invoke(line) }
    }

    PaymentTrackerReader.readInputFile("src/main/resources/initial_input_file.txt")
            .forEach { line -> parser.invoke(line) }

    val scanner = Scanner(System.`in`)

    while(true) {
        print("Enter something: ")
        val line : String = scanner.nextLine()
        if (line.equals("quit", true) || line.equals("q", true)) {
            print("Exiting!")
            break
        }
        parser.invoke(line)
    }

    scanner.close()

}
