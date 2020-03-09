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

    @GetMapping()
    public String clientPage(Model model) {
        model.addAttribute("clients", clientService.findAll());
        return "clients";
    }

    @PostMapping("/add")
    public String addClient(@RequestParam String name,
                            @RequestParam String surname,
                            @RequestParam String patronymic,
                            @RequestParam Integer experience,
                            @RequestParam String address,
                            @RequestParam String phone,
                            @RequestParam String passport) {
        clientService.save(name, surname, patronymic, experience, address, phone, passport);
        return "redirect:/clients";
    }

    @GetMapping("/delete/{delClient}")
    public String deleteClient(@PathVariable Long delClient) {
        clientService.remove(delClient);
        return "redirect:/clients";
    }

    @PostMapping("/reduct/{id}")
    public String reductClient(@PathVariable Long id,
                               @RequestParam String name,
                               @RequestParam String surname,
                               @RequestParam String patronymic,
                               @RequestParam Integer experience,
                               @RequestParam String address,
                               @RequestParam String phone,
                               @RequestParam String passport) {
        clientService.update(id, name, surname, patronymic, experience, address, phone, passport);
        return "redirect:/clients";
    }

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
