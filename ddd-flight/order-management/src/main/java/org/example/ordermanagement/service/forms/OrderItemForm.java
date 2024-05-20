package org.example.ordermanagement.service.forms;

import lombok.Data;

import org.example.ordermanagement.domain.valueobjects.Flight;
import org.example.ordermanagement.domain.valueobjects.Quantity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class OrderItemForm {
    @NotNull
    private Flight flight;

    @Min(1)
    private Quantity quantity = new Quantity();
}
