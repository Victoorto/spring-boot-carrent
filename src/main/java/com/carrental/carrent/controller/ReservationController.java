package com.carrental.carrent.controller;

import com.carrental.carrent.dao.ReservationRepository;
import com.carrental.carrent.entity.Reservation;
import com.carrental.carrent.services.ReservationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/reservations")
public class ReservationController {

    @Autowired
    ReservationServices reservationServices;

    @GetMapping(path="/{Id}")
    public void getReservationsById(@PathVariable("Id")Long Id){
        reservationServices.getReservationById(Id);
    }

    @PostMapping
    public void addReservation(@RequestBody Reservation reservation){
        reservationServices.addREservation(reservation);
    }

    @DeleteMapping
    public void deleteReservation(Long Id){
        reservationServices.removeReservation(Id);
    }




}
