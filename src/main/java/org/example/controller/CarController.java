package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.entity.Car;
import org.example.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cars")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class CarController {
    private final CarService carService;

    @GetMapping()
    public String carPage(Model model) {
        model.addAttribute("cars", carService.findAll());
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
        carService.save(model, color, bodyType, transmission, vehicleNumber, isFree, price);
        return "redirect:/cars";
    }

    @GetMapping("/delete/{delCar}")
    public String deleteCar(@PathVariable Long delCar) {
        carService.remove(delCar);
        return "redirect:/cars";
    }

    @PostMapping("/reduct/{id}")
    public String reductClient(@PathVariable Long id,
                               @RequestParam String model,
                               @RequestParam String color,
                               @RequestParam String bodyType,
                               @RequestParam String transmission,
                               @RequestParam String vehicleNumber,
                               @RequestParam String isFree,
                               @RequestParam Double price) {
        carService.update(id, model, color, bodyType, transmission, vehicleNumber, isFree, price);
        return "redirect:/cars";
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public Car getCarInJSON(@PathVariable Long id){
        return carService.findById(id);
    }

}
