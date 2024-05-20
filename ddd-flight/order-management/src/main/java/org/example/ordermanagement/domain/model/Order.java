package org.example.ordermanagement.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import org.example.ordermanagement.domain.valueobjects.Flight;
import org.example.ordermanagement.domain.valueobjects.Quantity;
import org.example.sharedkernel.domain.base.AbstractEntity;
import org.example.sharedkernel.domain.base.DomainObjectId;
import org.example.sharedkernel.domain.finacial.Currency;
import org.example.sharedkernel.domain.finacial.Money;

import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="orders")
@Getter
public class Order extends AbstractEntity<OrderId> {
    private Instant orderOn;

    @Enumerated(EnumType.STRING)
    private OrderState orderState;

    @Column(name="order_currency")
    @Enumerated(EnumType.STRING)
    private Currency currency;


    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<OrderItem> orderItemList = new HashSet<>();


    public Order(Instant now, Currency currency) {
        super(DomainObjectId.randomId(OrderId.class));
        this.orderOn = now;
        this.currency = currency;
    }

    protected Order() {
        super(DomainObjectId.randomId(OrderId.class));
    }

    public Money total() {
        return orderItemList.stream().map(OrderItem::subtotal).reduce(new Money(currency, 0.0), Money::add);
    }

    public OrderItem addItem(@NonNull Flight flight, Quantity qty) {
        Objects.requireNonNull(flight,"product must not be null");
        var item  = new OrderItem(flight.getId(),flight.getPrice(),qty);
        orderItemList.add(item);
        return item;
    }

    public void removeItem(@NonNull OrderItemId orderItemId) {
        Objects.requireNonNull(orderItemId,"Order Item must not be null");
        orderItemList.removeIf(v->v.getId().equals(orderItemId));
    }
}
