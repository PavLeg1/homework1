package com.hotel.hotel.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="amenities")
@Data
public class Amenities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Float priceChange;


    @ManyToMany
    @JoinColumn(name="rate_id", nullable = false)
    private Rate rate;

    public void setRate(Rate rate) {
    }
}
