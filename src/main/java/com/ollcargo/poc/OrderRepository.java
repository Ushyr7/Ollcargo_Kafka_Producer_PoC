package com.ollcargo.poc;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ollcargo.poc.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    public Optional<Order> findById(int id);

}
