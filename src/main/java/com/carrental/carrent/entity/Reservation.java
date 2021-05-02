package com.carrental.carrent.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
//Different entities for each table in MySQL


@Entity
@Table(name="reservations")
@Getter
@Setter

public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long reservation_id;

    @ManyToOne(targetEntity = Car.class)
    @JoinColumn(name="car_id")
    private Car car_id;

    @ManyToOne(targetEntity = Client.class)
    @JoinColumn(name="client_id")
    private Client client_id;


    private LocalDate start;

    @Column
    private LocalDate end;

    

}
