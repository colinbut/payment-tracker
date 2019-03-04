/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.pt.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UsagePrinter {

    public static void printUsage() {
        System.out.println("-------------------------------");
        System.out.println("java -jar PaymentTracker.jar [optional input file]");
        System.out.println("-------------------------------");
    }
}
