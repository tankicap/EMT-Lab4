package org.example.ordermanagement.service.forms;

import jakarta.validation.constraints.NotEmpty;

import lombok.Data;
import org.example.sharedkernel.domain.finacial.Currency;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
public class OrderForm{
    @NotNull
    private Currency currency;

    @Valid
    @NotEmpty
    private List<OrderItemForm> items = new ArrayList<>();
}
