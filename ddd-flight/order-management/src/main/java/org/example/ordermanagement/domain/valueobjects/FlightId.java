package org.example.ordermanagement.domain.valueobjects;

import jakarta.persistence.Embeddable;
import org.example.sharedkernel.domain.base.DomainObjectId;

@Embeddable
public class FlightId extends DomainObjectId {

    public FlightId() {
        super(FlightId.randomId(FlightId.class).getId());
    }

    public FlightId(String uuid) {
        super(uuid);
    }
}
