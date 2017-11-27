/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.pt.io;

import com.mycompany.pt.PaymentListing;
import com.mycompany.pt.model.CurrencyCode;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

@Slf4j
public class PaymentTrackerReader {

    private static PaymentListing paymentListing = PaymentListing.getInstance();

    public static void readInputFile(String inputFile) {
        try(BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while((line = reader.readLine()) != null) {
                String[] lineItems = line.split(" ");
                CurrencyCode currencyCode = CurrencyCode.valueOf(lineItems[0]);
                BigDecimal amount = new BigDecimal(lineItems[1]);
                paymentListing.addPayment(currencyCode, amount);
            }
        } catch (FileNotFoundException e) {
            log.error("File not found: {}", e);
        } catch (IOException e) {
            log.error("IO Problem: {}", e);
        }
    }
}
