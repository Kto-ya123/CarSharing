package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.entity.Car;
import org.example.entity.Client;
import org.example.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController {
    private final ClientService clientService;

    @GetMapping("/{id}")
    @ResponseBody
    public Client getClient(@PathVariable Long id){
        return clientService.findById(id);
    }

    @GetMapping()
    @ResponseBody
    public List<Client> getClients(){
        return clientService.findAll();
    }

    @PostMapping()
    @ResponseBody
    public Client newClient(@RequestBody Client client)
    {
        return clientService.save(
                client.getName(),
                client.getSurname(),
                client.getPatronymic(),
                client.getExperience(),
                client.getAddress(),
                client.getPhoneNumber(),
                client.getPassport());
    }

    @PutMapping()
    @ResponseBody
    public Client updateClient(@RequestBody Client client)
    {
        return clientService.update(client.getId(),
                client.getName(),
                client.getSurname(),
                client.getPatronymic(),
                client.getExperience(),
                client.getAddress(),
                client.getPhoneNumber(),
                client.getPassport());
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteClient(@PathVariable long id){
        clientService.remove(id);
    }

}
