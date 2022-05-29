package com.example.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class SenderController {

    @Autowired
    private JmsTemplate jmsTemplate;

    private final Logger logger = Logger.getLogger("SenderControllerLogger");

    @Value("${messages.queue.name}")
    private String queueName;


    @GetMapping(value = "/send/{message}", produces = "text/html")
    public void sendMessage (@PathVariable("message") String message) {
        jmsTemplate.convertAndSend(queueName, message);
        logger.log(Level.INFO, "Message '" + message + "' was sent");
    }

}
