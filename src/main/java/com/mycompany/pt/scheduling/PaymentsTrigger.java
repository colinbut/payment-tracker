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

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PaymentsTrigger {

    private static PaymentsTrigger INSTANCE = new PaymentsTrigger();

    public static PaymentsTrigger getInstance() {
        return INSTANCE;
    }

    public Trigger createTrigger() {
        Trigger trigger = TriggerBuilder.newTrigger()
            .withIdentity("myTrigger", "group1")
            .startAt(new DateTime().plusMinutes(1).toDate())
            .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(60).repeatForever())
            .build();

        log.info("Created Quartz Trigger: {}", trigger.getDescription());

        return trigger;
    }
}
