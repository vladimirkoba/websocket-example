package ru.liga.websocketexample.domain;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.Random;

public class MetricService {
    private final long maxRandomNumber;

    public MetricService(long maxRandomNumber) {
        this.maxRandomNumber = maxRandomNumber;
    }

    public MetricMessage generateRandomMetric() {
        return new MetricMessage(RandomStringUtils.randomAlphabetic(5), RandomUtils.nextInt(0, (int) maxRandomNumber));
    }
}
