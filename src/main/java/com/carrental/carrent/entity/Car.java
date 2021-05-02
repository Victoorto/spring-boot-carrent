package com.carrental.carrent.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="cars")
//@Data  Bug if used in OneToMany or ManyToOne better use @Getter and @Setter
@Getter
@Setter
public class Car {

    @Id // JPA mappings
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Just for the id column or primary key
    @Column
    public Long car_id;

    @Column
    private String model;

    @Column
    private String brand;

    @Column
    private String color;

    @Column
    private String plate;

    @Column
    private Integer year;

    @OneToMany(mappedBy = "car_id")
    private Set<Reservation> reservation = new HashSet<>();
}
