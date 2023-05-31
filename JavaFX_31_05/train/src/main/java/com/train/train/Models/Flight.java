package com.train.train.Models;

import java.sql.Date;
import java.sql.Time;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "flights")
@Data
public class Flight {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cityFrom;

    private String cityWhere;

    private Date dateDeparture;

    private Time timeDeparture;
    
    private Date dateArrival;

    private Time timeArrival;

    private Float basePrice;

    @ManyToOne
    @JoinColumn(name = "trainId")
    private Train train;
    
}
