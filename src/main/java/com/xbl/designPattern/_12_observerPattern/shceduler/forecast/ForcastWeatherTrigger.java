package com.xbl.designPattern._12_observerPattern.shceduler.forecast;



import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

@Component
@DisallowConcurrentExecution
@PersistJobDataAfterExecution
public class ForcastWeatherTrigger {
    @Autowired
    Scheduler scheduler;

    @PostConstruct
    public void initJob(){
        JobDetail job = newJob(ForecastWeatherJob.class).build();

        Trigger trigger = newTrigger().startNow().withSchedule(

                //0 0 8 * * ?
                CronScheduleBuilder.cronSchedule("0 30 7 * * ?")
        )
        .build();

        try {
            scheduler.scheduleJob(job,trigger);
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }
}

