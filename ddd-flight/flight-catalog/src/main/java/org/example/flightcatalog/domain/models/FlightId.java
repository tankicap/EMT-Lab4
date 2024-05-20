package org.example.flightcatalog.domain.models;

import lombok.NonNull;
import org.example.sharedkernel.domain.base.DomainObjectId;

public class FlightId extends DomainObjectId {
    protected FlightId(@NonNull String uuid) {
        super(uuid);
    }
}
