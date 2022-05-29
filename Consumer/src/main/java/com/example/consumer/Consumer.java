package com.example.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class Consumer {
    private final Logger logger = Logger.getLogger("ConsumerLogger");

    @JmsListener(destination = "${messages.queue.name}")
    public void processMessages(String message) {
        logger.log(Level.INFO, "Message '" + message + "' was got");
    }
}
