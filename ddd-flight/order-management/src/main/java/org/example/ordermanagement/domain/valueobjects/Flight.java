package org.example.ordermanagement.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.example.sharedkernel.domain.base.ValueObject;
import org.example.sharedkernel.domain.finacial.Currency;
import org.example.sharedkernel.domain.finacial.Money;

@Getter
public class Flight implements ValueObject {
    private final FlightId id;
    private final String Country;
    private final String City;
    private final int sales;


    private final Money price;

    private Flight() {
        this.id=FlightId.randomId(FlightId.class);
        this.Country= "";
        this.City="";
        this.sales = 0;
        this.price = Money.valueOf(Currency.MKD,0.0);
    }

    @JsonCreator
    public Flight(@JsonProperty("id") FlightId id,@JsonProperty("country") String country, @JsonProperty("city") String city,@JsonProperty("price") Money price, @JsonProperty("sales") int sales) {
        this.id = id;
        Country = country;
        City = city;
        this.price = price;
        this.sales=sales;
    }

}
