package payment.tracker

import payment.tracker.io.PaymentTrackerReader
import payment.tracker.util.UsagePrinter
import java.lang.IllegalArgumentException
import java.util.*

fun main(args: Array<String>) {

    val parser = Parser()

    PaymentTrackerReader.readInputFile("src/main/resources/initial_input_file.txt")

    if (args.size > 1) {
        UsagePrinter.printUsage()
        throw IllegalArgumentException("Invalid number of arguments")
    }

    if (args.size == 1){
        val optionalInputFile = args[0]
        val input = PaymentTrackerReader.readInputFile(optionalInputFile)
    }

    val scanner = Scanner(System.`in`)

    while(true) {
        print("Enter something: ")
        val line : String = scanner.nextLine()
        if (line.equals("quit", true) || line.equals("q", true)) {
            print("Exiting!")
            break;
        }
        parser.invoke(line)
    }

    scanner.close()

}
