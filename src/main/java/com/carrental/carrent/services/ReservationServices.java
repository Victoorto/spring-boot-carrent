package com.carrental.carrent.services;

import com.carrental.carrent.dao.ReservationRepository;
import com.carrental.carrent.entity.Client;
import com.carrental.carrent.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Optional;


@Service
public class ReservationServices {

    @Autowired
    private ReservationRepository reservationRepository;


    public Model getReservationByClientId(Long id, Model model){
        Optional<Reservation> Reservations = reservationRepository.getReservationByClientId(id);
        model.addAttribute("Reservations", Reservations);
        return model;
    }

    public Model getReservationByCarId(Long id, Model model){
        Optional<Reservation> Reservations = reservationRepository.getReservationByCarId(id);
        model.addAttribute("Reservations", Reservations);
        return model;
    }

    public void removeReservation(Long id){
        reservationRepository.deleteById(id);
    }

    public Reservation getReservationById(Long id){
        return reservationRepository.findById(id).get();
    }

    public void addREservation(Reservation reservation){
        reservationRepository.save(reservation);
    }
}
