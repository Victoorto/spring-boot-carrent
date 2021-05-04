package com.carrental.carrent.dao;

import com.carrental.carrent.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{



    //filter by client
    @Query(value = "SELECT r.* FROM reservations AS r WHERE r.client_id = id", nativeQuery = true)
    Optional<Reservation> getReservationByClientId(@Param("Id")Long id);

    //Filter by car
    @Query(value = "SELECT r.* FROM reservations AS r WHERE r.car_id = id", nativeQuery = true)
    Optional<Reservation> getReservationByCarId(@Param("Id")Long id);


}
