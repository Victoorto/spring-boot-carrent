package com.carrental.carrent.services;

import com.carrental.carrent.dao.ClientRepository;
import com.carrental.carrent.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServices {

    @Autowired
    ClientRepository clientRepository;

    public Client getClientById(Long id){
        return clientRepository.findById(id).get();
    }

    public void addClient(Client client){
        clientRepository.save(client);
    }

    public void removeClient(Long id){
        clientRepository.deleteById(id);
    }


}
