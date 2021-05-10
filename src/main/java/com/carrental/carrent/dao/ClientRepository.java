package com.carrental.carrent.dao;

import com.carrental.carrent.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface ClientRepository extends JpaRepository<Client, Long> {

}
