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

    @GetMapping(path = "/{id}")
    public Car getCar(@PathVariable("Id")Long id){
        return carRepository.findById(id).get();

    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Model getAvailableCars(@RequestParam("StartDate")  @DateTimeFormat(pattern = "dd-MM-yyyy")  LocalDate StartDate, @RequestParam("EndDate")  @DateTimeFormat(pattern = "dd-MM-yyyy")  LocalDate EndDate, Model model){

        Optional<Car> Cars = carRepository.Cars2(StartDate, EndDate);
        model.addAttribute("Cars", Cars);
        return model;
    }

    @PostMapping
    public String addCar(@RequestBody Car car){
            carRepository.save(car);
            return "Car Added";
    }

    @RequestMapping(path = "/availableCarsBrand")
    @ResponseBody
    public Model getAviailableCarsBrand(@RequestParam("StartDate")  @DateTimeFormat(pattern = "dd-MM-yyyy")  LocalDate StartDate, @RequestParam("EndDate")  @DateTimeFormat(pattern = "dd-MM-yyyy")  LocalDate EndDate,@RequestParam("Brand") String Brand ,Model model){
        Optional<Car> Cars = carRepository.availableCarsBrand(StartDate, EndDate, Brand);
        model.addAttribute("Cars", Cars);
        return model;
    }

    @DeleteMapping(path = "/delete")
    public String removeCar(@PathVariable("Id")Long id){
        carRepository.deleteById(id);
        return "deleted";
    }



}
