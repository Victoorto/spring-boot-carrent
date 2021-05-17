package com.carrental.carrent.services;


import com.carrental.carrent.dao.CarRepository;
import com.carrental.carrent.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class CarServices {

    @Autowired
    private CarRepository carRepository;


    //Get car by id
    public Car getCarById(Long id){
        return carRepository.findById(id).get();
    }

    //Get available cars without brand
    public Page getAvailableCars(LocalDate StartDate, LocalDate EndDate,Pageable pageable){
        Page<Car> Cars = carRepository.availableCars(StartDate, EndDate, pageable);
        return Cars;
    }

    //Get available cars with brand
    public Page getAvailableCarsBrand(LocalDate StartDate, LocalDate EndDate, String Brand, Pageable pageable){
        Page<Car> Cars = carRepository.availableCarsBrand(StartDate, EndDate, Brand, pageable);
        return Cars;
    }

    //Add a new car
    public void addCar(Car car){
        carRepository.save(car);
    }

    //Delete a car
    public void removeCar(Long id){
        carRepository.deleteById(id);
    }



}
