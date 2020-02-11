package org.example.service;

import org.example.entity.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {
    Car findById(Long id);

    List<Car> findAll();

    Car save(String model,
             String color,
             String bodyType,
             String transmission,
             String vehicleNumber,
             String isFree,
             Double price);

    Car update(Long id,
               String model,
               String color,
               String bodyType,
               String transmission,
               String vehicleNumber,
               String isFree,
               Double price);

    void remove(Long id);

    Optional<Car> findCarByVehicleNumber(String vehicleNumber);
}
