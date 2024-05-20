package org.example.ordermanagement.domain.repository;

import org.example.ordermanagement.domain.model.Order;
import org.example.ordermanagement.domain.model.OrderId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, OrderId> {
}
