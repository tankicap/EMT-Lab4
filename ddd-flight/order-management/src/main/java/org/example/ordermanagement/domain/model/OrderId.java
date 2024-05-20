package org.example.ordermanagement.domain.model;

import lombok.NonNull;
import org.example.sharedkernel.domain.base.DomainObjectId;

public class OrderId extends DomainObjectId {
    protected OrderId() {
        super(OrderId.randomId(OrderId.class).getId());
    }

    public OrderId(@NonNull String uuid) {
        super(uuid);
    }
}
