package com.appsdeveloperblog.ws.emailnotification.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "spring.kafka.consumer")
public class KafkaConsumerProperties {
    private String bootstrapServers;
    private String keyDeserializer;
    private String valueDeserializer;
    private String groupId;
    private PropertiesProperty properties;

    @Getter
    @Setter
    public static class PropertiesProperty {
        private String springJsonTrustedPackages;
        private boolean specificAvroReader;
        private String schemaRegistryUrl;

    }
}

