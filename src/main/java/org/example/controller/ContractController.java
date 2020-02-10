package org.example.controller;

import org.example.entity.Car;
import org.example.entity.Client;
import org.example.entity.Contract;
import org.example.repository.CarRepository;
import org.example.repository.ClientRepository;
import org.example.repository.ContractRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;
import java.util.Optional;

@Controller
@RequestMapping("/contracts")
public class ContractController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContractController.class);
    @Autowired
    ContractRepository contractRepository;

    @Autowired
    CarRepository carRepository;

    @Autowired
    ClientRepository clientRepository;


    @GetMapping()
    public String contractPage(Model model) {
        model.addAttribute("clients", clientRepository.findAll());
        model.addAttribute("cars", carRepository.findAll());
        model.addAttribute("contracts", contractRepository.findAll());
        return "contracts";
    }

    @PostMapping("/add")
    public String addContract(@RequestParam Car car,
                              @RequestParam Client client,
                              @RequestParam Date dateOfStart,
                              @RequestParam Date dateOfEnd) {
        Contract contract = new Contract();
        contract.setCar(car);
        contract.setClient(client);
        contract.setDateOfStart(dateOfStart);
        contract.setDateOfEnd(dateOfEnd);
        Long timeInDay = ((dateOfEnd.getTime() - dateOfStart.getTime()) / 1000 / 3600 / 24) + 1;
        Double totalCost = car.getPrice() * timeInDay;
        contract.setTotalCost(totalCost);
        contractRepository.save(contract);
        LOGGER.info("Add new contract with id " + contract.getId());
        return "redirect:/contracts";
    }

    @GetMapping("/delete/{delContract}")
    public String deleteContract(@PathVariable Integer delContract) {
        Optional<Contract> contractOptional = contractRepository.findById(delContract);
        if (contractOptional.isPresent()) {
            contractRepository.delete(contractOptional.get());
            LOGGER.info("Delete contract with id " + delContract);
        }
        return "redirect:/contracts";
    }

    @PostMapping("/reduct/{id}")
    public String reductContract(@PathVariable Integer id,
                                 @RequestParam Car car,
                                 @RequestParam Client client,
                                 @RequestParam Date dateOfStart,
                                 @RequestParam Date dateOfEnd) {
        Optional<Contract> contractOptional = contractRepository.findById(id);
        if (contractOptional.isPresent()) {
            Contract contract = contractOptional.get();
            contract.setCar(car);
            contract.setClient(client);
            dateOfStart.setDate(dateOfStart.getDate() + 1);
            contract.setDateOfStart(dateOfStart);
            dateOfEnd.setDate(dateOfEnd.getDate() + 1);
            contract.setDateOfEnd(dateOfEnd);
            Long timeInDay = (dateOfEnd.getTime() - dateOfStart.getTime()) / 1000 / 3600 / 24;
            Double totalCost = car.getPrice() * timeInDay;
            contract.setTotalCost(totalCost);
            contractRepository.save(contract);
            LOGGER.info("Update contract with id " + id);
        }

        return "redirect:/contracts";
    }

}
