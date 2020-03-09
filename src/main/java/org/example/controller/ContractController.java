package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.entity.Car;
import org.example.entity.Client;
import org.example.entity.Contract;
import org.example.service.CarService;
import org.example.service.ClientService;
import org.example.service.ContractService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;


@RestController
@RequestMapping("/contracts")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ContractController {
    private final ContractService contractService;
    private final CarService carService;
    private final ClientService clientService;

    /*@GetMapping()
    public String contractPage(Model model) {
        model.addAttribute("clients", clientService.findAll());
        model.addAttribute("cars", carService.findAll());
        model.addAttribute("contracts", contractService.findAll());
        return "contracts";
    }

    @PostMapping("/add")
    public String addContract(@RequestParam Car car,
                              @RequestParam Client client,
                              @RequestParam Date dateOfStart,
                              @RequestParam Date dateOfEnd) {
        contractService.save(car, client, dateOfStart, dateOfEnd);
        return "redirect:/contracts";
    }

    @GetMapping("/delete/{delContract}")
    public String deleteContract(@PathVariable Long delContract) {
        Contract contract = contractService.findById(delContract);
        contractService.remove(contract.getId());
        return "redirect:/contracts";
    }

    @PostMapping("/reduct/{id}")
    public String reductContract(@PathVariable Long id,
                                 @RequestParam Car car,
                                 @RequestParam Client client,
                                 @RequestParam Date dateOfStart,
                                 @RequestParam Date dateOfEnd) {
        contractService.update(id, car, client, dateOfStart, dateOfEnd);
        return "redirect:/contracts";
    }*/

    @GetMapping("/{id}")
    @ResponseBody
    public Contract getContract(@PathVariable Long id){
        return contractService.findById(id);
    }

    @GetMapping()
    @ResponseBody
    public List<Contract> getContracts(){
        return contractService.findAll();
    }

    @PostMapping()
    @ResponseBody
    public Contract newContract(@RequestBody Contract contract)
    {
        return contractService.save(
                contract.getCar(),
                contract.getClient(),
                contract.getDateOfStart(),
                contract.getDateOfEnd());
    }

    @PutMapping()
    @ResponseBody
    public Contract updateContract(@RequestBody Contract contract)
    {
        return contractService.update(contract.getId(),
                contract.getCar(),
                contract.getClient(),
                contract.getDateOfStart(),
                contract.getDateOfEnd());
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteContract(@PathVariable long id){
        contractService.remove(id);
    }

}
