package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/clients")
@RequiredArgsConstructor
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
                            @RequestParam String experience,
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
                               @RequestParam String experience,
                               @RequestParam String address,
                               @RequestParam String phone,
                               @RequestParam String passport) {
        clientService.update(id, name, surname, patronymic, experience, address, phone, passport);
        return "redirect:/clients";
    }

}
