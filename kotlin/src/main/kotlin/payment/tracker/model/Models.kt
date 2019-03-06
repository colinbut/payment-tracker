/*
 * |-------------------------------------------------
 * | Copyright © 2019 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package payment.tracker.model

import java.math.BigDecimal

enum class CurrencyCode(val code: String) {
    USD("USD"),
    HKD("HKD"),
    RMB("RMB")
}

data class MoneyAmount(val currencyCode: CurrencyCode, var amount: BigDecimal)


