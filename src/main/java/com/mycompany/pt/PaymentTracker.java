/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.pt;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

@Slf4j
public class PaymentTracker {

    private static final String INITIAL_INPUT_FILE_NAME = "";

    private static List<MoneyAmount> paymentAmounts = new ArrayList<>();


    private static File initialInputFile = new File(INITIAL_INPUT_FILE_NAME);

    public static void main(String[] args) {

        try(BufferedReader reader = new BufferedReader(new FileReader(initialInputFile))) {
            String line;
            while((line = reader.readLine()) != null) {
                String[] lineItems = line.split(" ");
                Currency currency = Currency.getInstance(lineItems[0]);
                BigDecimal amount = new BigDecimal(lineItems[1]);
                paymentAmounts.add(new MoneyAmount(currency, amount));
            }
        } catch (FileNotFoundException e) {
            log.error("File not found: {}", e);
        } catch (IOException e) {
            log.error("IO Exception: {}", e);
        }

    }
}
