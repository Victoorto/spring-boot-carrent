package com.carrental.carrent.dao;

import com.carrental.carrent.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

    //Filter by car

    //filter by client



}
