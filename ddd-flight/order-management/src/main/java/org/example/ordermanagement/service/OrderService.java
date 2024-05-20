package org.example.ordermanagement.service;

import org.example.ordermanagement.domain.exceptions.OrderIdNotExistException;
import org.example.ordermanagement.domain.exceptions.OrderItemIdNotExistException;
import org.example.ordermanagement.domain.model.Order;
import org.example.ordermanagement.domain.model.OrderId;
import org.example.ordermanagement.domain.model.OrderItemId;
import org.example.ordermanagement.service.forms.OrderForm;
import org.example.ordermanagement.service.forms.OrderItemForm;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    OrderId placeOrder(OrderForm orderForm);

    List<Order> findAll();

    Optional<Order> findById(OrderId id);

    void addItem(OrderId orderId, OrderItemForm orderItemForm) throws OrderIdNotExistException;

    void deleteItem(OrderId orderId, OrderItemId orderItemId) throws OrderIdNotExistException, OrderItemIdNotExistException;
}
