package com.cydeo.entity;

import com.cydeo.enums.PaymentMethod;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Payment extends BaseEntity{

    private BigDecimal paidPrice;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Override
    public String toString() {
        return "Payment{" +
                "paidPrice=" + paidPrice +
                ", paymentMethod=" + paymentMethod +
                '}';
    }
}
