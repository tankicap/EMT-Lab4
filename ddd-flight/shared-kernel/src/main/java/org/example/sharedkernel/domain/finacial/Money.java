package org.example.sharedkernel.domain.finacial;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NonNull;
import org.example.sharedkernel.domain.base.ValueObject;

import java.util.Objects;


@Embeddable
@Getter
public class Money implements ValueObject {
    @Enumerated(value = EnumType.STRING)
    private final Currency currency;

    private final Double amount;
    protected Money(){
        this.amount=0.0;
        this.currency = null;
    }
    public Money(@NonNull Currency currency, @NonNull Double amount){
        this.currency=currency;
        this.amount = amount;
    }

    public static Money valueOf(Currency currency, Double amount) {
        return new Money(currency,amount);
    }

    public Money add(Money money) {
        if (!currency.equals(money.currency)) {
            throw new IllegalArgumentException("Cannot add two Money objects with different currencies");
        }
        return new Money(currency,amount + money.amount);
    }

    public Money subtract(Money money) {
        if (!currency.equals(money.currency)) {
            throw new IllegalArgumentException("Cannot add two Money objects with different currencies");
        }
        return new Money(currency,amount - money.amount);
    }

    public Money multiply(int m)  {
        return new Money(currency,amount*m);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount == money.amount && currency == money.currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, amount);
    }
}
