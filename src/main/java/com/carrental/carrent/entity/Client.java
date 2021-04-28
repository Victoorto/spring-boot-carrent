package com.carrental.carrent.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name ="clients")
//@Data  //Lombok automatically generate the @getter/@setter methods to reduce boilerplace code
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long client_id;

    @Column
    private String name;

    @Column
    private String  mail;

    @Column
    private String password;

    @Column
    private Integer age;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private Set<Reservation> reservation = new HashSet<>();



}
