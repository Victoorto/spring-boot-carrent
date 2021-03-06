package com.carrental.carrent.dao;

import com.carrental.carrent.entity.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;


@CrossOrigin("http://localhost:4200")
public interface  CarRepository extends JpaRepository<Car, Long> {


    @Query(value ="SELECT c.* FROM cars AS c LEFT JOIN reservations AS r ON c.car_id = r.car_id WHERE ((StartDate NOT BETWEEN r.start AND r.end) AND (EndDate NOT BETWEEN r.start AND  r.end)) OR r.reservation_id IS NULL;", nativeQuery = true )
    Page<Car> availableCars(@Param("StartDate")LocalDate from, @Param("EndDate")LocalDate to,  Pageable pageable);

    @Query(value ="SELECT c.* FROM cars AS c LEFT JOIN reservations AS r ON c.car_id = r.car_id WHERE ((StartDate NOT BETWEEN r.start AND r.end) AND (EndDate NOT BETWEEN r.start AND  r.end)) OR r.reservation_id IS NULL HAVING c.brand = brand;", nativeQuery = true )
    Page<Car> availableCarsBrand(@Param("StartDate")LocalDate from, @Param("EndDate")LocalDate to, @Param("Brand")String brand,  Pageable pageable);

    Page<Car> findByCarType(@RequestParam("type") String si, Pageable pageable);


}
