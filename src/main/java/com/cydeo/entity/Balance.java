package com.cydeo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Balance extends BaseEntity{

    private BigDecimal amount;

    @OneToOne
    private Customer customer;

    @Override
    public String toString() {
        return "Balance{" +
                "amount=" + amount +
                ", customer=" + customer +
                '}';
    }
}
