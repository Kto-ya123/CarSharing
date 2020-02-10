package org.example.controller;

import org.example.entity.Accident;
import org.example.entity.Client;
import org.example.entity.Contract;
import org.example.repository.AccidentRepository;
import org.example.repository.ClientRepository;
import org.example.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ContractRepository contractRepository;

    @Autowired
    AccidentRepository accidentRepository;

    @GetMapping()
    public String clientPage(Model model){
        List<Client> clients = clientRepository.findAll();
        model.addAttribute("clients", clients);
        return "clients";
    }

    @PostMapping("/add")
    public String addClient(@RequestParam String name,
                            @RequestParam String surname,
                            @RequestParam String patronymic,
                            @RequestParam String experience,
                            @RequestParam String address,
                            @RequestParam String phone,
                            @RequestParam String passport,
                            Model model){
        Client client = new Client();
        client.setName(name);
        client.setSurname(surname);
        client.setPatronymic(patronymic);
        client.setAddress(address);
        client.setExperience(Integer.parseInt(experience));
        client.setPassport(passport);
        client.setPhoneNumber(phone);
        clientRepository.save(client);
        return "redirect:/clients";
    }

    @GetMapping("/delete/{delClient}")
    public String deleteClient(@PathVariable Integer delClient){
        Optional<Client> client = clientRepository.findById(delClient);
        if(client.isPresent()) {
            List<Contract> contracts = contractRepository.findContractByClient(client.get());
            for (Contract contract : contracts) {

                accidentRepository.deleteAll(accidentRepository.findAccidentByContract(contract));
            }
            contractRepository.deleteAll(contracts);
            clientRepository.delete(client.get());
        }
        return "redirect:/clients";
    }

    @PostMapping("/reduct/{id}")
    public String reductClient(@PathVariable Integer id,
                            @RequestParam String name,
                            @RequestParam String surname,
                            @RequestParam String patronymic,
                            @RequestParam String experience,
                            @RequestParam String address,
                            @RequestParam String phone,
                            @RequestParam String passport){
        Optional<Client> clientOptional = clientRepository.findById(id);
        if(clientOptional.isPresent()) {
            Client client = clientOptional.get();
            client.setName(name);
            client.setSurname(surname);
            client.setPatronymic(patronymic);
            client.setAddress(address);
            client.setExperience(Integer.parseInt(experience));
            client.setPassport(passport);
            client.setPhoneNumber(phone);
            clientRepository.save(client);
        }
        return "redirect:/clients";
    }

}
