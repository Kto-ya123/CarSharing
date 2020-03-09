package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.Accident;
import org.example.entity.Car;
import org.example.entity.Contract;
import org.example.service.AccidentService;
import org.example.service.ContractService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/accidents")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class AccidentController {
    private final AccidentService accidentService;
    private final ContractService contractService;

    /*@GetMapping()
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
    }*/

    @GetMapping("/{id}")
    @ResponseBody
    public Accident getAccident(@PathVariable Long id){
        return accidentService.findById(id);
    }

    @GetMapping()
    @ResponseBody
    public List<Accident> getAccidents(){
        return accidentService.findAll();
    }

    @PostMapping()
    @ResponseBody
    public Accident newAccident(@RequestBody Accident accident)
    {
        return accidentService.save(
                accident.getContract(),
                accident.getDateOfAccident(),
                accident.getCostOfDamage());
    }

    @PutMapping()
    @ResponseBody
    public Accident updateAccident(@RequestBody Accident accident)
    {
        return accidentService.update(accident.getId(),
                accident.getContract(),
                accident.getDateOfAccident(),
                accident.getCostOfDamage());
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteAccident(@PathVariable long id){
        accidentService.remove(id);
    }

}
