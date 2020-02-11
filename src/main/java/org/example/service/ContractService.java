package org.example.service;

import org.example.entity.Car;
import org.example.entity.Client;
import org.example.entity.Contract;

import java.sql.Date;
import java.util.List;

public interface ContractService {
    Contract findById(Long id);

    List<Contract> findAll();

    Contract save(Car car,
                  Client client,
                  Date dateOfStart,
                  Date dateOfEnd);

    Contract update(Long id,
                    Car car,
                    Client client,
                    Date dateOfStart,
                    Date dateOfEnd);

    void remove(Long id);

    List<Contract> findContractByClient(Client client);

    List<Contract> findContractByCar(Car car);
}
