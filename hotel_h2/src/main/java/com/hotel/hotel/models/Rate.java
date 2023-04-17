package com.hotel.hotel.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "rates")
@Data
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Связываем с услугами Many - to - Many
    @JsonIgnore
    @ManyToMany
    @JoinColumn(name = "amenities_id", nullable = false)
    private Amenities amenities;


    // Расчет стоимости ночи ведется тут
    private Float price;



    // Связать с заказом
}
