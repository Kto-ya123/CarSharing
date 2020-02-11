package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.Car;
import org.example.repository.AccidentRepository;
import org.example.repository.CarRepository;
import org.example.repository.ContractRepository;
import org.example.service.CarService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final ContractRepository contractRepository;
    private final AccidentRepository accidentRepository;

    @Transactional
    @Override
    public Car findById(Long id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new ServiceException(String.format("There is no car with %s", id)));
        log.info("Find car with id " + id);
        return car;
    }

    @Transactional
    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Transactional
    @Override
    public Car save(String model, String color, String bodyType, String transmission,
                    String vehicleNumber, String isFree, Double price) {
        Optional<Car> exitCar = carRepository.findCarByVehicleNumber(vehicleNumber);
        if (exitCar.isPresent()) {
            throw new ServiceException(String.format("Car with this vehicle number has already exist"));
        }
        Car car = new Car();
        car.setModel(model);
        car.setColor(color);
        car.setBodyType(bodyType);
        car.setTransmission(transmission);
        car.setVehicleNumber(vehicleNumber);
        car.setIsFree(Boolean.parseBoolean(isFree));
        car.setPrice(price);
        log.info("Successfully adding new car");
        return carRepository.save(car);
    }

    @Transactional
    @Override
    public Car update(Long id, String model, String color, String bodyType, String transmission,
                      String vehicleNumber, String isFree, Double price) {
        return carRepository.findById(id)
                .map(car -> {
                    car.setColor(color);
                    car.setModel(model);
                    car.setBodyType(bodyType);
                    car.setTransmission(transmission);
                    car.setVehicleNumber(vehicleNumber);
                    car.setIsFree(Boolean.parseBoolean(isFree));
                    car.setPrice(price);
                    carRepository.save(car);
                    log.info("Update car with id " + id);
                    return car;
                }).orElseThrow(() -> new IllegalArgumentException(String.format("There is no car with such id %s", id)));
    }

    @Transactional
    @Override
    public void remove(Long id) {
        contractRepository.findContractByCar(carRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(String.format("There is no car with id %s", id)))).
                forEach(contract -> {
                    contractRepository.delete(contract);
                    accidentRepository.deleteAll(accidentRepository.findAccidentByContract(contract));
                });
        carRepository.deleteById(id);
        log.info("Delete car with id " + id);
    }

    @Transactional
    @Override
    public Optional<Car> findCarByVehicleNumber(String vehicleNumber) {
        return carRepository.findCarByVehicleNumber(vehicleNumber);
    }
}
