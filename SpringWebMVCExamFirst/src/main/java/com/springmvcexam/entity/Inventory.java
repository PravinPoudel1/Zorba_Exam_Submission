package com.springmvcexam.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "inventory")
@Data
public class Inventory {

    @Id
    @Column(name = "inventory_id")
    private Integer inventoryId;
    @Column(name = "inventory_name")
    private String inventoryName;
    @Column(name = "inventory_quantity")
    private String inventoryQuantity;
    @Column(name = "inventory_price")
    private String inventoryPrice;
    @Column(name = "inventory_image")
    private String inventoryImage;
    @Column(name = "inventory_desc")
    private String inventoryDesc;

    public Inventory(int i, String productA, int i1) {
    }
}
