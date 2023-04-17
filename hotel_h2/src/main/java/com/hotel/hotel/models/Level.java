package com.hotel.hotel.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "levels")
@Data
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private Float basePrice;
}
