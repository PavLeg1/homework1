package com.train.train.Models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * The Train class represents a train entity with its associated attributes.
 */
@Entity
@Table(name = "trains")
@Data
public class Train {

    /**
     * The unique identifier for this Train.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The name of this Train.
     */
    private String name;

    /**
     * The type of this Train.
     */
    private String type;

    /**
     * The number of wagons on this Train.
     */
    private Integer wagonNumber;

    /**
     * The number of seats per wagon on this Train.
     */
    private Integer seatsPerWagon;

    /**
     * The list of Flights associated with this Train.
     */
    @JsonIgnore
    @OneToMany(mappedBy = "train")
    private List<Flight> flights;
}