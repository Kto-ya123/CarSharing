package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.Accident;
import org.example.entity.Contract;
import org.example.service.AccidentService;
import org.example.service.ContractService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@Controller
@RequestMapping("/accidents")
@RequiredArgsConstructor
@Slf4j
public class AccidentController {
    private final AccidentService accidentService;
    private final ContractService contractService;

    @GetMapping()
    public String accidentPage(Model model) {
        model.addAttribute("contracts", contractService.findAll());
        model.addAttribute("accidents", accidentService.findAll());
        return "accidents";
    }


    @PostMapping("/add")
    public String addContract(@RequestParam Contract contract,
                              @RequestParam Date dateOfAccident,
                              @RequestParam Double costOfDamage) {
        accidentService.save(contract, dateOfAccident, costOfDamage);
        return "redirect:/accidents";
    }


    @GetMapping("/delete/{delAccident}")
    public String deleteContract(@PathVariable Long delAccident) {
        Accident accident = accidentService.findById(delAccident);
        accidentService.remove(accident.getId());
        return "redirect:/accidents";
    }

    @PostMapping("/reduct/{id}")
    public String reductContract(@PathVariable Long id,
                                 @RequestParam Contract contract,
                                 @RequestParam Date dateOfAccident,
                                 @RequestParam Double costOfDamage) {
        accidentService.update(id, contract, dateOfAccident, costOfDamage);
        return "redirect:/accidents";
    }

}
