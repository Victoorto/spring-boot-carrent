package com.carrental.carrent.services;


import com.carrental.carrent.dao.CarRepository;
import com.carrental.carrent.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Model getAvailableCars(LocalDate StartDate, LocalDate EndDate, Model model){
        Optional<Car> Cars = carRepository.availableCars(StartDate, EndDate);
        model.addAttribute("Cars", Cars);
        return model;
    }

    //Get available cars with brand
    public Model getAvailableCarsBrand(LocalDate StartDate, LocalDate EndDate, String Brand, Model model){
        Optional<Car> Cars = carRepository.availableCarsBrand(StartDate, EndDate, Brand);
        model.addAttribute("Cars", Cars);
        return model;
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
