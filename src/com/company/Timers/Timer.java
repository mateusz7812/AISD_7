package com.company.Timers;

import java.time.Duration;
import java.util.Date;

public class Timer implements TimerInterface {
    long start;

    @Override
    public void Start() {
        start = System.nanoTime()/1000;
    }

    @Override
    public Duration GetCurrentValue() {
        var end = System.nanoTime()/1000;
        return Duration.between(new Date(start).toInstant(), new Date(end).toInstant());
    }
}
