/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.pt.scheduling;

import com.mycompany.pt.PaymentListing;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@Slf4j
public class PaymentListingJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.debug("Running scheduling job: {}", jobExecutionContext.getJobDetail());

        System.out.println(PaymentListing.getInstance().getPaymentAmounts());
    }
}
