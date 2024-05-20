package org.example.flightcatalog.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import org.example.sharedkernel.domain.base.AbstractEntity;
import org.example.sharedkernel.domain.base.DomainObjectId;
import org.example.sharedkernel.domain.finacial.Money;

@Entity
@Data
@Table(name = "flight")
public class Flight extends AbstractEntity<FlightId> {

    private  String Country;
    private String City;

    private Money price;
    private int sales;

    protected Flight() {
        super(DomainObjectId.randomId(FlightId.class));
    }


    public static Flight build(String County,String City, Money price, Integer sales) {
        Flight f = new Flight();
        f.price = price;
        f.Country =County;
        f.sales = sales;
        f.City=City;
        return f;
    }

    public void addSales(Integer qty) {
        this.sales = this.sales - qty;
    }

    public void removeSales(Integer qty) {
        this.sales -= qty;
    }

}
