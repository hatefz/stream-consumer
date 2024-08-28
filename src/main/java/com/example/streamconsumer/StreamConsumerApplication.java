package com.example.streamconsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.messaging.SubscribableChannel;

@SpringBootApplication
@EnableBinding(ConsumerChannels.class)
public class StreamConsumerApplication {

    private final String HEADER = "EVENT_TYPE";
    private final String SPECIAL_NUMBER_EVENT = "SPECIAL_NUMBER_EVENT";
    private final String OPERATOR_EVENT = "OPERATOR_EVENT";

    private static final Logger log = LoggerFactory.getLogger(StreamConsumerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(StreamConsumerApplication.class, args);
    }

    private IntegrationFlow incomingMessageFlow(SubscribableChannel incoming) {
        return IntegrationFlows
                .from(incoming)
                .handle(
                        SpecialNumberEvent.class,
                        (event, headers) -> {
                            log.info("{} {}", event.getEventType(), event.getSpecialNumber());
                            return null;
                        }).get();
    }

//    @Bean
//    IntegrationFlow consume(ConsumerChannels channels) {
//        return incomingMessageFlow(channels.streamConsumeTest());
//    }

    @StreamListener(value = ConsumerChannels.STREAM,  condition = "headers['EVENT_TYPE']=='OPERATOR_EVENT'")
    public void consumer2(OperatorEvent event) {
        log.info("{} {} {}", event.getEventType(), event.getName(), event.getPrice());
    }

    @StreamListener(value = ConsumerChannels.STREAM, condition = "headers['EVENT_TYPE']=='SPECIAL_NUMBER_EVENT'")
    public void consumer1(SpecialNumberEvent event) {
        log.info("{} {}", event.getEventType(), event.getSpecialNumber());
    }

}
