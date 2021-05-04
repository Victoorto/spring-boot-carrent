package com.carrental.carrent.controller;

import com.carrental.carrent.dao.ClientRepository;
import com.carrental.carrent.entity.Car;
import com.carrental.carrent.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
@RequestMapping(path = "/client")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping(path = "/{id}")
    public Client getClient(@PathVariable("Id")Long id){
        return clientRepository.findById(id).get();
    }

    @PostMapping
    public String addClient(@RequestBody Client client){
        clientRepository.save(client);
        return "Client Added";
    }

    @DeleteMapping(path = "/delete")
    public String removeClient(@PathVariable("Id")Long id){
        clientRepository.deleteById(id);
        return "deleted";
    }


}
