package org.example.flightcatalog.domain.repository;

import org.example.flightcatalog.domain.models.Flight;
import org.example.flightcatalog.domain.models.FlightId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, FlightId> {
}
