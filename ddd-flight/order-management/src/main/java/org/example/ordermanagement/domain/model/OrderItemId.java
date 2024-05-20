package org.example.ordermanagement.domain.model;

import lombok.NonNull;
import org.example.sharedkernel.domain.base.DomainObjectId;

import java.util.UUID;

public class OrderItemId extends DomainObjectId {
    protected OrderItemId() {
        super(UUID.randomUUID().toString());
    }

    public OrderItemId(@NonNull String uuid) {
        super(uuid);
    }
}
