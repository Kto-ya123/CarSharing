package org.example.controller;

import org.example.entity.Accident;
import org.example.entity.Car;
import org.example.entity.Client;
import org.example.entity.Contract;
import org.example.repository.AccidentRepository;
import org.example.repository.CarRepository;
import org.example.repository.ClientRepository;
import org.example.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Optional;

@Controller
@RequestMapping("/accidents")
public class AccidentController {
    @Autowired
    ContractRepository contractRepository;

    @Autowired
    AccidentRepository accidentRepository;

    @GetMapping()
    public String accidentPage(Model model){
        model.addAttribute("contracts", contractRepository.findAll());
        model.addAttribute("accidents", accidentRepository.findAll());
        return "accidents";
    }


    @PostMapping("/add")
    public String addContract(@RequestParam Contract contract,
                            @RequestParam Date dateOfAccident,
                            @RequestParam Double costOfDamage){
        Accident accident = new Accident();
        accident.setContract(contract);
        dateOfAccident.setDate(dateOfAccident.getDate() + 1);
        accident.setDateOfAccident(dateOfAccident);
        accident.setCostOfDamage(costOfDamage);
        accidentRepository.save(accident);

        return "redirect:/accidents";
    }


    @GetMapping("/delete/{delAccident}")
    public String deleteContract(@PathVariable Integer delAccident){
        Optional<Accident> accidentOptional = accidentRepository.findById(delAccident);
        if(accidentOptional.isPresent()) {
            accidentRepository.delete(accidentOptional.get());
        }
        return "redirect:/accidents";
    }

    @PostMapping("/reduct/{id}")
    public String reductContract(@PathVariable Integer id,
                                 @RequestParam Contract contract,
                                 @RequestParam Date dateOfAccident,
                                 @RequestParam Double costOfDamage){
        Optional<Accident> accidentOptional = accidentRepository.findById(id);
        if(accidentOptional.isPresent()) {
            Accident accident = accidentOptional.get();
            accident.setContract(contract);
            dateOfAccident.setDate(dateOfAccident.getDate() + 1);
            accident.setDateOfAccident(dateOfAccident);
            accident.setCostOfDamage(costOfDamage);
            accidentRepository.save(accident);
        }

        return "redirect:/accidents";
    }

}
