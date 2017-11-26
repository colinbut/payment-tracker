/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.pt;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Currency;

@Data
@AllArgsConstructor
public class MoneyAmount {

    private Currency currency;
    private BigDecimal amount;
}
