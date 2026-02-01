package org.incois.backend.tasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestScheduler {

    @Scheduled(fixedRate = 5000)
    public void test() {
        System.out.println("Scheduler is working! " + System.currentTimeMillis());
    }
}

