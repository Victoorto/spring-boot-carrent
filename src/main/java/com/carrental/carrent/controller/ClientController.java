package com.carrental.carrent.controller;


import com.carrental.carrent.entity.Client;
import com.carrental.carrent.services.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;




@Controller
@RequestMapping(path = "/client")
public class ClientController {

    @Autowired
    ClientServices clientServices;

    @GetMapping(path = "/{id}")
    public void getClient(@PathVariable("Id")Long id){
        clientServices.getClientById(id);
    }

    @PostMapping
    public void addClient(@RequestBody Client client){
      clientServices.addClient(client);
    }

    @DeleteMapping(path = "/delete")
    public void removeClient(@PathVariable("Id")Long id){
        clientServices.removeClient(id);
    }


}
