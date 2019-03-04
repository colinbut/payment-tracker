/*
 * |-------------------------------------------------
 * | Copyright © 2019 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package payment.tracker.io

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

object PaymentTrackerReader {
    fun readInputFile(file: String) : List<String> {
        return BufferedReader(FileReader(File(file))).readLines()
    }
}
