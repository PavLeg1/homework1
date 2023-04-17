package com.hotel.hotel.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="facilities")
@Data
public class Facilities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany
    @JoinColumn(name="room_id", nullable = false)
    private Room room;

    public void setFacilities(Facilities facilities) {
    }
}
