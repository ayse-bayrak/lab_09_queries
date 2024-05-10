package com.cydeo.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Category extends BaseEntity {

    private String name;

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", id=" + getId() +
                '}';
    }
}
