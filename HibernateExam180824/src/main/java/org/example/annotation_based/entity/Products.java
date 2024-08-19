package org.example.annotation_based.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Product")
@Getter
@Setter

public class Products {
    @Id
    public String productId;

    @Column(name = "productName" , length = 50)
    public String productName;

    @Column(name = "productQuantity" , length =40)
    public int productQuantity;

    @ManyToOne
    @JoinColumn(name = "custId", referencedColumnName = "custId")
    private Customers customers;

    @ManyToOne
    @JoinColumn(name = "prod_type_id", referencedColumnName = "prodTypeId")
    private ProductsType productsType;

    @Override
    public String toString() {
        return "Products{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productQuantity=" + productQuantity +
                ", customers=" + customers +
                ", productsType=" + productsType +
                '}';
    }

    public void setProductId(String productId) {
    }
}
