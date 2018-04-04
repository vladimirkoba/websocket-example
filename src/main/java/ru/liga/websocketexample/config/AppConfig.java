package ru.liga.websocketexample.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.liga.websocketexample.domain.MetricService;

@Configuration
public class AppConfig {

    @Bean
    public MetricService metricService() {
        return new MetricService(100L);
    }
}
