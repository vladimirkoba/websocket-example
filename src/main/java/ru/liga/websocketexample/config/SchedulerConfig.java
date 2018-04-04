package ru.liga.websocketexample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import ru.liga.websocketexample.domain.MetricService;


@Configuration
@EnableScheduling
@Import(AppConfig.class)
public class SchedulerConfig {
    private final SimpMessagingTemplate template;
    private final MetricService metricService;

    @Autowired
    public SchedulerConfig(SimpMessagingTemplate template, MetricService metricService) {
        this.template = template;
        this.metricService = metricService;
    }

    @Scheduled(fixedRate = 1000)
    public void generateNewMetric(){
        template.convertAndSend("/topic/metrics", metricService.generateRandomMetric());
    }
}
