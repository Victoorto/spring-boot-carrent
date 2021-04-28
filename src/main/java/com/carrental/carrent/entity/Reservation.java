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

    @ManyToOne
    @JoinColumn(name="car_id")
    private Long car_id;

    @ManyToOne
    @JoinColumn(name="client_id")
    private Long client_id;


    private LocalDate start;

    @Column
    private LocalDate end;

    

}
