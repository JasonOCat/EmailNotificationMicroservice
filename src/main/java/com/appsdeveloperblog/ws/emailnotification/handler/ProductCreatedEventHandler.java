package com.appsdeveloperblog.ws.emailnotification.handler;

import com.appsdeveloperblog.ws.emailnotification.error.NotRetryableException;
import com.appsdeveloperblog.ws.emailnotification.error.RetryableException;
import com.appsdeveloperblog.ws.products.ProductCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
@RequiredArgsConstructor
public class ProductCreatedEventHandler {

    private final RestTemplate restTemplate;

    @KafkaListener(topics = "product-created-events-topic")
//    public void handle(ConsumerRecord<String, ProductCreatedEvent> consumerRecord) {
    public void handle(
            @Payload ProductCreatedEvent productCreatedEvent,
            @Header("messageId") String messageId,
            @Header(KafkaHeaders.RECEIVED_KEY) String messageKey
    ) {

//        if (true) {
//            throw new NotRetryableException("Simulated error");
//        }

//        ProductCreatedEvent productCreatedEvent = consumerRecord.value();

        log.info("Received a new event: {}", productCreatedEvent.getTitle());

        // Decode the decimal logical type from the Avro "price" field
        // BigDecimal price = decodeDecimal(productCreatedEvent.getPrice(), 2);

        // fake remote service
        String requestUrl = "http://localhost:8082";

//        try {
//            ResponseEntity<String> response = restTemplate.exchange(requestUrl, HttpMethod.GET, null, String.class);
//
//            if (response.getStatusCode().value() == HttpStatus.OK.value()) {
//                log.info("Response from a remote service: {}", response.getBody());
//            }
//        } catch (HttpClientErrorException ex) {
//            log.error(ex.getMessage());
//            throw new RetryableException(ex);
//        } catch (HttpServerErrorException ex) {
//            log.error(ex.getMessage());
//            throw new NotRetryableException(ex);
//        } catch (Exception ex) {
//            log.error(ex.getMessage());
//            throw new NotRetryableException(ex);
//        }

        log.info("****** Received ProductCreatedEvent ******");
        log.info("Product ID: {}", productCreatedEvent.getProductId());
        log.info("Title: {}", productCreatedEvent.getTitle());
        log.info("Title: {}", productCreatedEvent.getPrice());
        //log.info("Price: {}", price); // Log deserialized BigDecimal

        log.info("Quantity: {}", productCreatedEvent.getQuantity());


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
