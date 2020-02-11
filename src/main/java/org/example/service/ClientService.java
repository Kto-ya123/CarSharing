package org.example.service;

import org.example.entity.Client;

import java.util.List;
import java.util.Optional;


public interface ClientService {
    Client findById(Long id);

    List<Client> findAll();

    Client save(String name,
                String surname,
                String patronymic,
                String experience,
                String address,
                String phone,
                String passport);

    Client update(Long id,
                  String name,
                  String surname,
                  String patronymic,
                  String experience,
                  String address,
                  String phone,
                  String passport);

    void remove(Long id);

    Optional<Client> findClientByPassport(String passport);
}
