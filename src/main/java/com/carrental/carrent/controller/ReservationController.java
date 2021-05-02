package com.carrental.carrent.controller;

import com.carrental.carrent.dao.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/reservations")
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;


}
