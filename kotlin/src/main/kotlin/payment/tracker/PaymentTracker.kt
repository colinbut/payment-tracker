package payment.tracker

import payment.tracker.io.PaymentTrackerReader
import payment.tracker.schedule.PaymentScheduler
import payment.tracker.util.UsagePrinter
import java.lang.IllegalArgumentException
import java.util.*
import kotlin.collections.HashMap

val paymentListing = PaymentListing(HashMap())
val parser = Parser(paymentListing)
val paymentScheduler = PaymentScheduler()

const val DEFAULT_INPUT_FILE = "src/main/resources/initial_input_file.txt"

fun main(args: Array<String>) {

    paymentScheduler.schedulePaymentListing()

    when {
        args.isEmpty() -> readDefaultInputFile()
        args.size == 1 -> readInputFileFromCommandLine(args)
        args.size > 1 -> showErrorAndExit()
    }

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

fun readDefaultInputFile() = PaymentTrackerReader.readInputFile(DEFAULT_INPUT_FILE)
        .forEach { line -> parser.invoke(line) }

fun readInputFileFromCommandLine(args: Array<String>) = PaymentTrackerReader.readInputFile(args[0])
        .forEach { line -> parser.invoke(line) }

fun showErrorAndExit() {
    UsagePrinter.printUsage()
    throw IllegalArgumentException("Invalid number of arguments")
}