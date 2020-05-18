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

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/contracts")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200", "http://ec2-18-188-63-75.us-east-2.compute.amazonaws.com"})
public class ContractController {
    private final ContractService contractService;

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
