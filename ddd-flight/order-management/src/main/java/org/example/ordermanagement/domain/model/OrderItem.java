package org.example.ordermanagement.domain.model;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import org.example.ordermanagement.domain.valueobjects.FlightId;
import org.example.ordermanagement.domain.valueobjects.Quantity;
import org.example.sharedkernel.domain.base.AbstractEntity;
import org.example.sharedkernel.domain.base.DomainObjectId;
import org.example.sharedkernel.domain.finacial.Money;

@Entity
@Table(name = "order_item")
@Getter
public class OrderItem extends AbstractEntity<OrderItemId>  {
    private Money itemPrice;

    @Column(nullable = false)
    private Quantity quantity;

    @AttributeOverride(name = "id", column = @Column(name = "flight_id", nullable = false))
    private FlightId flightId;

    public OrderItem(@NonNull FlightId flightId, @NonNull Money itemPrice, Quantity qty) {
        super(DomainObjectId.randomId(OrderItemId.class));
        this.flightId = flightId;
        this.itemPrice = itemPrice;
        this.quantity = qty;
    }

    protected OrderItem() {}



    public Money subtotal() {
        return itemPrice.multiply(quantity.getQuantity());
    }

}
