package com.hotel.hotel.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name= "rooms")
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Integer floor;
    private String description;

    // Связываем с удобствами Many - to - Many
    @JsonIgnore
    @ManyToMany
    @JoinColumn(name = "facilities_id", nullable = false)
    private Facilities facilities;
}
