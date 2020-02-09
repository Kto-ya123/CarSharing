package org.example.controller;

import org.example.entity.Client;
import org.example.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientRepository clientRepository;

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

}
