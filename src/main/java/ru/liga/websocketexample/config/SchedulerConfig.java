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
    @Autowired
    private SimpMessagingTemplate template;

    @Autowired
    MetricService metricService;

    @Scheduled(fixedRate = 1000)
    public void publishUpdates(){
        template.convertAndSend("/topic/metrics", metricService.generateRandomMetric());
    }
}
