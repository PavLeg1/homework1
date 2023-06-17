package com.store.store.Models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="number")
    private Integer number;

    // @Column(name="all_weight")
    // private Float all_weight;

    public void updateOrder(Order order){
        if(order.number != null)    { this.number = order.number; }
        // if(product.pr_weight != null)     { this.pr_weight = product.pr_weight; }
    }
    
    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<Product> products;

}
