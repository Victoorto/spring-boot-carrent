package com.carrental.carrent.controller;


import com.carrental.carrent.entity.Car;
import com.carrental.carrent.services.CarServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
    public void getCar(@PathVariable("id")Long id){
         carServices.getCarById(id);
    }

    @RequestMapping(path ="/carAvailables",method = RequestMethod.GET)
    @ResponseBody
    public void getAvailableCars(@RequestParam("StartDate")  @DateTimeFormat(pattern = "dd-MM-yyyy")  LocalDate StartDate, @RequestParam("EndDate")  @DateTimeFormat(pattern = "dd-MM-yyyy")  LocalDate EndDate, Pageable pageable){
        carServices.getAvailableCars(StartDate, EndDate,pageable);
    }

    @RequestMapping(path = "/availableCarsBrand", method = RequestMethod.GET)
    @ResponseBody
    public void getAviailableCarsBrand(@RequestParam("StartDate")  @DateTimeFormat(pattern = "dd-MM-yyyy")  LocalDate StartDate, @RequestParam("EndDate")  @DateTimeFormat(pattern = "dd-MM-yyyy")  LocalDate EndDate, @RequestParam("Brand") String Brand , Pageable pageable){
        carServices.getAvailableCarsBrand(StartDate, EndDate, Brand, pageable);
    }

    @PostMapping(path="/addCar")
    public void addCar(@RequestBody Car car){
       carServices.addCar(car);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void removeCar(@PathVariable("id")Long id){
        carServices.removeCar(id);
    }

}
