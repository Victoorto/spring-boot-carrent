package com.carrental.carrent.dao;

import com.carrental.carrent.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
