/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.pt.scheduling;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;

@Slf4j
public class PaymentsScheduler {

    private Scheduler scheduler;
    private PaymentsTrigger paymentsTrigger = PaymentsTrigger.getInstance();

    public void schedulePaymentListings() {
        startScheduler();

        JobDetail jobDetail = newJob(PaymentListingJob.class).withIdentity("myJob", "group1").build();

        try {
            scheduler.scheduleJob(jobDetail, paymentsTrigger.createTrigger());
        } catch (SchedulerException e) {
            log.error("Unable to schedule job {}", e);
            throw new RuntimeException(e);
        }
    }

    private void startScheduler() {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        try {
            scheduler = schedulerFactory.getScheduler();
            scheduler.start();
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }
}
