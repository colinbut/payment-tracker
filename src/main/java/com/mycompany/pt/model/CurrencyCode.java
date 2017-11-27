/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.pt.model;

public enum  CurrencyCode {

    USD("USD"),
    HKD("HKD"),
    RMB("RMB");

    CurrencyCode(String code) {
        this.code = code;
    }

    private String code;
}
