package com.carrental.carrent.dao;

import com.carrental.carrent.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Optional;

public interface  CarRepository extends JpaRepository<Car, Long> {

    @Query(value ="SELECT c.* FROM cars AS c LEFT JOIN reservations AS r ON c.car_id = r.car_id WHERE ((StartDate NOT BETWEEN r.start AND r.end) AND (EndDate NOT BETWEEN r.start AND  r.end)) OR r.reservation_id IS NULL;", nativeQuery = true )
    Optional<Car> availableCars(@Param("StartDate")LocalDate from, @Param("EndDate")LocalDate to);

    @Query(value ="SELECT c.* FROM cars AS c LEFT JOIN reservations AS r ON c.car_id = r.car_id WHERE ((StartDate NOT BETWEEN r.start AND r.end) AND (EndDate NOT BETWEEN r.start AND  r.end)) OR r.reservation_id IS NULL HAVING c.brand = brand;", nativeQuery = true )
    Optional<Car> availableCarsBrand(@Param("StartDate")LocalDate from, @Param("EndDate")LocalDate to, @Param("Brand")String brand);


}
