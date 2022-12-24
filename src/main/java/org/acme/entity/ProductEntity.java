package org.acme.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name_product")
    public String name;

    @Column(name = "sector_product")
    public String sector;

    @Column(name = "brand_product")
    public String brand;

    @Column(name = "price_product")
    public Double price;

    public ProductEntity() {

    }

    public ProductEntity(String name, String sector, String brand, Double price) {
        this.name = name;
        this.sector = sector;
        this.brand = brand;
        this.price = price;
    }

}
