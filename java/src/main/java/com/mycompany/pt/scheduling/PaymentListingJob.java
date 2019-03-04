/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.pt.scheduling;

import com.mycompany.pt.PaymentListing;
import com.mycompany.pt.model.CurrencyCode;
import com.mycompany.pt.model.MoneyAmount;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.math.BigDecimal;
import java.util.Map;

@Slf4j
public class PaymentListingJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.debug("Running scheduling job: {}", jobExecutionContext.getJobDetail());

        StringBuilder sb = new StringBuilder();
        Map<CurrencyCode, MoneyAmount> paymentAmounts = PaymentListing.getInstance().getPaymentAmounts();
        for (Map.Entry<CurrencyCode, MoneyAmount> entry : paymentAmounts.entrySet()) {
            if (entry.getValue().getAmount().equals(BigDecimal.ZERO)) {
                continue;
            }
            sb.append(entry.getKey()).append(" ").append(entry.getValue().getAmount());
            sb.append("\n");
        }

        log.info(sb.toString());
    }
}
