package com.appsdeveloperblog.ws.emailnotification.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "spring.kafka.producer")
public class KafkaProducerProperties {
    private String bootstrapServers;
    private String keySerializer;
    private String valueSerializer;

}

