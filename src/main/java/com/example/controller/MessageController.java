package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class MessageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageController.class);
    private final String message;

    public MessageController(@Value("${message: Default Message}") String message) {
        this.message = message;
    }

    @GetMapping("/message")
    public String getMessage() {
        LOGGER.info("Message : {}", message);
        return message;
    }
}
