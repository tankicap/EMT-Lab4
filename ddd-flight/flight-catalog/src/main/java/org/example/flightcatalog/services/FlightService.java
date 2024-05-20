package org.example.flightcatalog.services;

import org.example.flightcatalog.domain.models.Flight;
import org.example.flightcatalog.domain.models.FlightId;
import org.example.flightcatalog.services.forms.FlightForm;

import java.util.List;

public interface FlightService {
    Flight findById(FlightId id);
    Flight createProduct(FlightForm form);
    Flight orderItemCreated(FlightId flightId, int quantity);
    Flight orderItemRemoved(FlightId flightId, int quantity);
    List<Flight> getAll();
}
