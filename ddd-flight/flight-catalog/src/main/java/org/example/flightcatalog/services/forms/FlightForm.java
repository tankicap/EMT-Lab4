package org.example.flightcatalog.services.forms;

import lombok.Data;
import org.example.sharedkernel.domain.finacial.Money;

@Data
public class FlightForm {
    private String Country;
    private String City;
    private Money price;
    private Integer sales;
}
