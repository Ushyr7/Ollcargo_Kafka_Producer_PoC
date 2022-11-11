package com.ollcargo.poc.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ollcargo.poc.OrderRepository;
import com.ollcargo.poc.model.Order;
import com.ollcargo.poc.service.KafkaProducerService;

@RestController
public class KafkaController {
	
	@Autowired
	private OrderRepository orderRepository;

    @Autowired
    KafkaProducerService kafkaProducer;

    @RequestMapping("/")  
    public String hello() {  
    	return "Seems like it's working !";  
    } 
    
    @GetMapping("/order")
    public List<Order> getAllOrders(){
    	return orderRepository.findAll();
    }
    
    @GetMapping("/order/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable(value = "id") final int orderId) {
        Optional<Order> orderData = orderRepository.findById(orderId);

        if (orderData.isPresent()) {
          return new ResponseEntity<Order>(orderData.get(), HttpStatus.OK);
        } else {
          return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/order")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        try {
            Order o = orderRepository
                .save(new Order(order.getId(), order.getDeliveryAmount(), order.getClientAmount()));
            return new ResponseEntity<Order>(o, HttpStatus.CREATED);
          } catch (Exception e) {
            return new ResponseEntity<Order>(HttpStatus.INTERNAL_SERVER_ERROR);
          }
    }
    
    @PostMapping("/order/{id}/kafka")
    public ResponseEntity<Order> sendMessage(@PathVariable(value = "id") final int orderId) {
        Optional<Order> orderData = orderRepository.findById(orderId);

        if (orderData.isPresent()) {
        	Order o = orderData.get();
        	kafkaProducer.send(o);
          return new ResponseEntity<Order>(HttpStatus.OK);
        } else {
          return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
        }
    }
}
