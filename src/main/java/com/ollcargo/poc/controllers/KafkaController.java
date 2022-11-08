package com.ollcargo.poc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ollcargo.poc.model.Order;
import com.ollcargo.poc.service.KafkaProducerService;

@RestController
public class KafkaController {

    @Autowired
    KafkaProducerService kafkaProducer;

    @RequestMapping("/")  
    public String hello() {  
    	return "Hello World";  
    } 
    
    @PostMapping("/order")
    public String sendMessage(@RequestBody Order order)
    {
        kafkaProducer.send(order);
        return "Message sent successfully to the Kafka topic order";
    }
}
