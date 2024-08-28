package com.example.streamconsumer;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface ConsumerChannels {
    String STREAM = "event-stream-test";

    @Input(STREAM)
    SubscribableChannel streamConsumeTest();
}