/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.pt.scheduling;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;

import java.util.Date;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PaymentsTrigger {

    private static final Date TRIGGER_START_TIME = new DateTime().plusMinutes(1).toDate();
    private static final int SCHEDULE_INTERVAL_IN_SECONDS = 60;

    private static PaymentsTrigger INSTANCE = new PaymentsTrigger();

    public static PaymentsTrigger getInstance() {
        return INSTANCE;
    }

    public Trigger createTrigger() {
        Trigger trigger = TriggerBuilder.newTrigger()
            .withIdentity("paymentListingTrigger", "group1")
            .startAt(TRIGGER_START_TIME)
            .withSchedule(
                SimpleScheduleBuilder.simpleSchedule()
                    .withIntervalInSeconds(SCHEDULE_INTERVAL_IN_SECONDS)
                    .repeatForever())
            .build();

        log.info("Created Quartz Trigger: {}", trigger);

        return trigger;
    }
}
