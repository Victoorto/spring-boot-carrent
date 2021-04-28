package com.carrental.carrent.DAO;

import com.carrental.carrent.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface clientRepository extends JpaRepository<Client, Long> {
}
