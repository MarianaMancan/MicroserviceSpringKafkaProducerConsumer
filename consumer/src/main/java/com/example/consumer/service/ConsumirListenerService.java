package com.example.consumer.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumirListenerService {

	 private final Logger logger = LoggerFactory.getLogger(ConsumirListenerService.class);

	    @KafkaListener(topics = "${topic.bora-praticar}", groupId = "group_id")
	    public void consume(String message) throws IOException {
	        logger.info(String.format("Consumindo mensagem {}", message));
	    }
}
