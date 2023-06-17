package com.store.store.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="products")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="type")
    private String pr_type;  
    
    @Column(name="weight")
    private Float pr_weight;

    public void updateProduct(Product product){
        if(product.pr_type != null)    { this.pr_type = product.pr_type; }

        if(product.pr_weight != null)     { this.pr_weight = product.pr_weight; }
    }


    @ManyToOne
    @JoinColumn(name="order_id", nullable = false)
    private Order order;


}
