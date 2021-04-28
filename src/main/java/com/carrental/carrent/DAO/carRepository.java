package com.carrental.carrent.DAO;

import com.carrental.carrent.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface carRepository extends JpaRepository<Car, Long> {
}
