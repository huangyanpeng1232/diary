package com.diary.timg;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTask {

    @Scheduled(fixedRate=60000)
    private void configureTasks() {
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
    }
}
