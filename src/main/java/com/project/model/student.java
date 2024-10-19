package com.project.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int stud_id;
    private String stud_name;
    private String age;

    @OneToOne(mappedBy = "students")
   @JsonManagedReference // Parent side
    private product products;

    // Getters and Setters
    public int getStud_id() {
        return stud_id;
    }

    public void setStud_id(int stud_id) {
        this.stud_id = stud_id;
    }

    public String getStud_name() {
        return stud_name;
    }

    public void setStud_name(String stud_name) {
        this.stud_name = stud_name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public product getProducts() {
        return products;
    }

    public void setProducts(product products) {
        this.products = products;
    }

    // Constructors
    public student(int stud_id, String stud_name, String age, product products) {
        super();
        this.stud_id = stud_id;
        this.stud_name = stud_name;
        this.age = age;
        this.products = products;
    }

    public student() {
        super();
    }
    
    @Override
    public String toString() {
        return "student{" +
                "stud_id=" + stud_id +
                ", stud_name='" + stud_name + '\'' +
                ", age='" + age + '\'' +
                ", product=" + (products != null ? products.getPro_id() : "null") +
                '}';
    }

    
}
