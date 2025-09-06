package com.appsdeveloperblog.ws.emailnotification.handler;

import com.appsdeveloperblog.ws.emailnotification.error.NotRetryableException;
import com.appsdeveloperblog.ws.products.ProductCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;

@Component

@Slf4j
public class ProductCreatedEventHandler {

    @KafkaListener(topics = "product-created-events-topic")
    public void handle(ConsumerRecord<String, ProductCreatedEvent> consumerRecord) {

        if (true) {
            throw new NotRetryableException("Simulated error");
        }
        ProductCreatedEvent productCreatedEvent = consumerRecord.value();

        // Decode the decimal logical type from the Avro "price" field
        // BigDecimal price = decodeDecimal(productCreatedEvent.getPrice(), 2);

        log.info("****** Received ProductCreatedEvent ******");
        log.info("Product ID: {}", productCreatedEvent.getProductId());
        log.info("Title: {}", productCreatedEvent.getTitle());
        log.info("Title: {}", productCreatedEvent.getPrice());
        //log.info("Price: {}", price); // Log deserialized BigDecimal

        log.info("Quantity: {}", productCreatedEvent.getQuantity());

        log.info("Received a new event: {}", productCreatedEvent.getTitle());
    }

    // Decode ByteBuffer to BigDecimal
//    private BigDecimal decodeDecimal(ByteBuffer byteBuffer, int scale) {
//        // Convert ByteBuffer to BigInteger
//        BigInteger unscaledValue = new BigInteger(byteBuffer.array());
//
//        // Apply scale to BigInteger to get BigDecimal
//        return new BigDecimal(unscaledValue, scale);
//    }

}
