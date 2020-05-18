package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.entity.Car;
import org.example.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200", "http://ec2-18-188-63-75.us-east-2.compute.amazonaws.com"})
public class CarController {
    private final CarService carService;

    @GetMapping("/{id}")
    @ResponseBody
    public Car getCar(@PathVariable Long id){
        return carService.findById(id);
    }

    @GetMapping()
    @ResponseBody
    public List<Car> getCars(){
        return carService.findAll();
    }

    @PostMapping()
    @ResponseBody
    public Car newCar(@RequestBody Car car)
    {
        return carService.save(
                car.getModel(),
                car.getColor(),
                car.getBodyType(),
                car.getTransmission(),
                car.getVehicleNumber(),
                Boolean.toString(car.getIsFree()),
                car.getPrice());
    }

    @PutMapping()
    @ResponseBody
    public Car updateCar(@RequestBody Car car)
    {
        return carService.update(car.getId(),
                car.getModel(),
                car.getColor(),
                car.getBodyType(),
                car.getTransmission(),
                car.getVehicleNumber(),
                Boolean.toString(car.getIsFree()),
                car.getPrice());
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteCar(@PathVariable long id){
        carService.remove(id);
    }
}
