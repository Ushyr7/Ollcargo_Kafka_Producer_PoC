package com.ollcargo.poc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.ollcargo.poc.model.Order;

@Service
public class KafkaProducerService {
    private final Logger LOG = LoggerFactory.getLogger(KafkaProducerService.class);
    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    String kafkaTopic = "order";

    public void send(Order order) {
        LOG.info("Sending User Json Serializer : {}", order);
        kafkaTemplate.send(kafkaTopic, order);
    }
}