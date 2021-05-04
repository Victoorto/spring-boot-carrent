package com.carrental.carrent.controller;


import com.carrental.carrent.entity.Car;
import com.carrental.carrent.services.CarServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@Controller
@RequestMapping(path="/cars")
public class CarController {

    @Autowired
    CarServices carServices;

    @GetMapping(path = "/{id}")
    public void getCar(@PathVariable("Id")Long id){
         carServices.getCarById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public void getAvailableCars(@RequestParam("StartDate")  @DateTimeFormat(pattern = "dd-MM-yyyy")  LocalDate StartDate, @RequestParam("EndDate")  @DateTimeFormat(pattern = "dd-MM-yyyy")  LocalDate EndDate, Model model){
        carServices.getAvailableCars(StartDate, EndDate, model);
    }

    @RequestMapping(path = "/availableCarsBrand")
    @ResponseBody
    public void getAviailableCarsBrand(@RequestParam("StartDate")  @DateTimeFormat(pattern = "dd-MM-yyyy")  LocalDate StartDate, @RequestParam("EndDate")  @DateTimeFormat(pattern = "dd-MM-yyyy")  LocalDate EndDate,@RequestParam("Brand") String Brand ,Model model){
        carServices.getAvailableCarsBrand(StartDate, EndDate, Brand, model);
    }

    @PostMapping
    public void addCar(@RequestBody Car car){
       carServices.addCar(car);
    }

    @DeleteMapping(path = "/delete")
    public void removeCar(@PathVariable("Id")Long id){
        carServices.removeCar(id);
    }

}
