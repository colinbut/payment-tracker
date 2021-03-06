/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.pt;

import com.mycompany.pt.io.Command;
import com.mycompany.pt.io.PaymentTrackerReader;
import com.mycompany.pt.scheduling.PaymentsScheduler;
import com.mycompany.pt.util.UsagePrinter;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class PaymentTracker {

    private static final String INITIAL_INPUT_FILE_NAME = "initial_input_file.txt";


    public static void main(String[] args) {

        PaymentTrackerReader.readInputFile("src/main/resources/" + INITIAL_INPUT_FILE_NAME);

        new PaymentsScheduler().schedulePaymentListings();

        if (args.length > 1) {
            UsagePrinter.printUsage();
            throw new IllegalArgumentException("Invalid number of arguments supplied");
        }

        if (args.length == 1) {
            String optionalInputFile = args[0];
            PaymentTrackerReader.readInputFile(optionalInputFile);
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter Something: ");

            String input = scanner.nextLine();

            if (Command.Q_COMMAND.getCommand().equalsIgnoreCase(input) || Command.QUIT_COMMAND.getCommand().equalsIgnoreCase(input)) {
                System.out.println("Exiting!");
                break;
            }

            Parser.getInstance().invoke(input);
        }

        scanner.close();

        System.exit(1);
    }

}
