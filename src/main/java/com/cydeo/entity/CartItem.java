package com.cydeo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CartItem extends BaseEntity{

    private Integer quantity;

    @ManyToOne
    private Cart cart;

    @ManyToOne
    private Product product;

    @Override
    public String toString() {
        return "CartItem{" +
                "quantity=" + quantity +
                ", cart=" + cart +
                ", product=" + product +
                '}';
    }
}
