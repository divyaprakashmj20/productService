package com.myCompany.store.product.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer catId;

    public Product(){

    }

    public Product(Integer id, String name, Integer catId) {
        this.id = id;
        this.name = name;
        this.catId = catId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    //    public Product(Integer id, String name, Integer catId) {
//        this.id = id;
//        this.name = name;
//        this.catId = catId;
//    }
//
//    public Product() {
//    }
//
//    public Product(int id) {
//        this.id = id;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getCatId() {
//        return catId;
//    }
//
//    public void setCatId(int catId) {
//        this.catId = catId;
//    }
}
