package org.example.annotation_based.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Product_Type")
@Getter
@Setter
public class ProductsType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Product_Type" , length = 30)
    private System produceType;

    @Column(name = "rate" ,length = 10)
    private double rate;

    @Override
    public String toString() {
        return "ProductType{" +
                "id=" + id +
                ", produceType=" + produceType +
                ", rate=" + rate +
                '}';
    }
}
