package com.carrental.carrent.controller;

import com.carrental.carrent.dao.CarRepository;
import com.carrental.carrent.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping(path="/cars")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @GetMapping(path = "/cars/{id}")
    public String getCar(@PathVariable("Id")Long id){

        Optional<Car> car = carRepository.findById(id);
        if(car.isPresent()){
            return "show car";
        }
        return null;

    }

    @RequestMapping("/availableCars")
    public String availableCars(@RequestParam("StartDate")  @DateTimeFormat(pattern = "dd-MM-yyyy")  LocalDate StartDate, @RequestParam("EndDate")  @DateTimeFormat(pattern = "dd-MM-yyyy")  LocalDate EndDate, Model model){
        Optional<Car> Cars = carRepository.availableCars(StartDate, EndDate);
        model.addAttribute("Cars", Cars);
        return "display Cars";
    }

    @PostMapping
    public String addCar(@RequestBody Car car){
            carRepository.save(car);
            return "Car Added";
    }

    @RequestMapping("/availableCarsBrand")
    public String aviailableCarsBrand(@RequestParam("StartDate")  @DateTimeFormat(pattern = "dd-MM-yyyy")  LocalDate StartDate, @RequestParam("EndDate")  @DateTimeFormat(pattern = "dd-MM-yyyy")  LocalDate EndDate,@RequestParam("Brand") String Brand ,Model model){
        Optional<Car> Cars = carRepository.availableCarsBrand(StartDate, EndDate, Brand);
        model.addAttribute("Cars", Cars);
        return "display cars";
    }

    @DeleteMapping
    public String removeCar(@PathVariable("Id")Long id){
        carRepository.deleteById(id);
        return "deleted";
    }



}
