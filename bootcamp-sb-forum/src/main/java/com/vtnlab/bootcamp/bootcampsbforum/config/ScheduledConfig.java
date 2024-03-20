package com.vtnlab.bootcamp.bootcampsbforum.config;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class ScheduledConfig {
    // @Scheduled(fixedRate=5000)
    public void fixedRateTask() throws InterruptedException{
        System.out.println("hello rate");
        Thread.sleep(4000);
        System.out.println("end Rate");
    }

    // @Scheduled(fixedDelay=2000)
    public void fixedDelayTask() throws InterruptedException{
        System.out.println("hello delay");
        Thread.sleep(4000);
        System.out.println("end delay");
    }

    // @Scheduled(cron="5 * * * * ?") // similar to fixedDelay
    @Async
    public void cronTask5() throws InterruptedException {
        System.out.println("start cron5");
        Thread.sleep(10000);
        System.out.println("end cron5");
    }

    // @Scheduled(cron="10 * * * * ?") // similar to fixedDelay
    @Async
    public void cronTask10() throws InterruptedException {
        System.out.println("start cron10");
        Thread.sleep(10000);
        System.out.println("end cron10");
    }
}
