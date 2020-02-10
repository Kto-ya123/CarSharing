package org.example.controller;

import org.example.entity.Car;
import org.example.entity.Contract;
import org.example.repository.AccidentRepository;
import org.example.repository.CarRepository;
import org.example.repository.ContractRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cars")
public class CarController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CarController.class);
    @Autowired
    CarRepository carRepository;
    @Autowired
    ContractRepository contractRepository;
    @Autowired
    AccidentRepository accidentRepository;

    @GetMapping()
    public String carPage(Model model) {
        List<Car> cars = carRepository.findAll();
        model.addAttribute("cars", cars);
        return "cars";
    }

    @PostMapping("/add")
    public String addCar(@RequestParam String model,
                         @RequestParam String color,
                         @RequestParam String bodyType,
                         @RequestParam String transmission,
                         @RequestParam String vehicleNumber,
                         @RequestParam String isFree,
                         @RequestParam Double price) {
        Car car = new Car();
        car.setModel(model);
        car.setColor(color);
        car.setBodyType(bodyType);
        car.setTransmission(transmission);
        car.setVehicleNumber(vehicleNumber);
        car.setIsFree(Boolean.parseBoolean(isFree));
        car.setPrice(price);
        carRepository.save(car);
        LOGGER.info("Add car with id " + car.getId());
        return "redirect:/cars";
    }

    @GetMapping("/delete/{delCar}")
    public String deleteCar(@PathVariable Integer delCar) {
        Optional<Car> car = carRepository.findById(delCar);
        if (car.isPresent()) {
            List<Contract> contracts = contractRepository.findContractByCar(car.get());
            for (Contract contract : contracts) {
                accidentRepository.deleteAll(accidentRepository.findAccidentByContract(contract));
            }
            contractRepository.deleteAll(contracts);
            carRepository.delete(car.get());
            LOGGER.info("Delete car with id " + delCar);
        }
        return "redirect:/cars";
    }

    @PostMapping("/reduct/{id}")
    public String reductClient(@PathVariable Integer id,
                               @RequestParam String model,
                               @RequestParam String color,
                               @RequestParam String bodyType,
                               @RequestParam String transmission,
                               @RequestParam String vehicleNumber,
                               @RequestParam String isFree,
                               @RequestParam Double price) {
        Optional<Car> carOptional = carRepository.findById(id);
        if (carOptional.isPresent()) {
            Car car = carOptional.get();
            car.setColor(color);
            car.setBodyType(bodyType);
            car.setTransmission(transmission);
            car.setVehicleNumber(vehicleNumber);
            car.setIsFree(Boolean.parseBoolean(isFree));
            car.setPrice(price);
            carRepository.save(car);
            LOGGER.info("Update car with id " + id);
        }
        return "redirect:/cars";
    }

}
