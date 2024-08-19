package org.example.annotation_based.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Customer")
@Getter
@Setter

public class Customers {
    @Id
    private int id;

    @Column(name = "custName", length = 20)
    private String custName;

    @Column(name = "custEmail" , length = 30)
    private String custEmail;

    @Column(name = "custMobile" , length = 10)
    private String custMobile;

    @Column(name = "finalProductPrice" , length = 25)
    private double finalProductPrice;

    @Override
    public String toString() {
        return "Customers{" +
                "id=" + id +
                ", custName='" + custName + '\'' +
                ", custEmail='" + custEmail + '\'' +
                ", custMobile='" + custMobile + '\'' +
                ", finalProductPrice=" + finalProductPrice +
                '}';
    }

    public void setCustId(String custId) {
    }
}
