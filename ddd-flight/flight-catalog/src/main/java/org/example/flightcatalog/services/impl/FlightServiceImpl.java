package org.example.flightcatalog.services.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.flightcatalog.domain.models.Flight;
import org.example.flightcatalog.domain.models.FlightId;
import org.example.flightcatalog.domain.repository.FlightRepository;
import org.example.flightcatalog.services.FlightService;
import org.example.flightcatalog.services.forms.FlightForm;
import org.springframework.stereotype.Service;
import org.example.flightcatalog.domain.exception.FlightNotFound;


import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class FlightServiceImpl implements FlightService {
    private final FlightRepository flightRepository;
    @Override
    public Flight findById(FlightId id) {

        return flightRepository.findById(id).orElseThrow(FlightNotFound::new);
    }

    @Override
    public Flight createProduct(FlightForm form) {
        Flight p = Flight.build(form.getCountry(),form.getCity(),form.getPrice(),form.getSales());
        flightRepository.save(p);
        return p;
    }

    @Override
    public Flight orderItemCreated(FlightId productId, int quantity) {
        Flight p = findById(productId);
        p.addSales(quantity);
        flightRepository.saveAndFlush(p);
        return p;

    }

    @Override
    public Flight orderItemRemoved(FlightId productId, int quantity) {
        Flight p = flightRepository.findById(productId).orElseThrow(FlightNotFound::new);
        p.removeSales(quantity);
        flightRepository.saveAndFlush(p);
        return p;

    }

    @Override
    public List<Flight> getAll() {
        return flightRepository.findAll();
    }

}
