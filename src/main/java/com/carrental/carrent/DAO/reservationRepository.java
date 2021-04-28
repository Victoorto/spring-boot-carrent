package com.carrental.carrent.dao;

import com.carrental.carrent.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface reservationRepository extends JpaRepository<Reservation, Long>{
}
