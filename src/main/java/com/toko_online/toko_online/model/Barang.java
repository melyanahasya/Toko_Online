package com.toko_online.toko_online.model;

import com.toko_online.toko_online.editing.Auditable;

import javax.persistence.*;

@Entity
@Table(name = "barang")
public class Barang extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price")
    private Float price;

    @Column(name = "count")
    private Integer count;

    @Column(name = "reting")
    private Integer reting;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "publish")
    private Boolean publish;


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getReting() {
        return reting;
    }

    public void setReting(Integer reting) {
        this.reting = reting;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getPublish() {
        return publish;
    }

    public void setPublish(Boolean publish) {
        this.publish = publish;
    }

    @Override
    public String toString() {
        return "barang{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", reting=" + reting +
                ", description='" + description + '\'' +
                ", publish=" + publish +
                '}';
    }
}
