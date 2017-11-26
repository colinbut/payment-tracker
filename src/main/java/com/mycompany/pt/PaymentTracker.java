/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.pt;

import com.mycompany.pt.scheduling.PaymentsScheduler;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class PaymentTracker {

    private static final String INITIAL_INPUT_FILE_NAME = "";

    private static PaymentListing paymentListing = PaymentListing.getInstance();

    private static void printUsage() {
        System.out.println("-------------------------------");
        System.out.println("java -jar PaymentTracker.jar [optional input file]");
        System.out.println("-------------------------------");
    }

    public static void main(String[] args) {

        new PaymentsScheduler().schedulePaymentListings();

        readInitialInputFile(INITIAL_INPUT_FILE_NAME);

        if (args.length > 1) {
            printUsage();
            throw new IllegalArgumentException("Invalid number of arguments supplied");
        }

        String optionalInputFile = args[0];
        readInitialInputFile(optionalInputFile);
    }

    private static void readInitialInputFile(String inputFile) {
        try(BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while((line = reader.readLine()) != null) {
                String[] lineItems = line.split(" ");
                Currency currency = Currency.getInstance(lineItems[0]);
                BigDecimal amount = new BigDecimal(lineItems[1]);
                paymentListing.addPayment(currency, amount);
            }
        } catch (FileNotFoundException e) {
            log.error("File not found: {}", e);
        } catch (IOException e) {
            log.error("IO Problem: {}", e);
        }
    }
}
