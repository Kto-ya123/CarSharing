package org.example.repository;

import org.example.entity.Car;
import org.example.entity.Client;
import org.example.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {
    List<Contract> findContractByClient(Client client);

    List<Contract> findContractByCar(Car car);

    List<Contract> findContractByClientAndCar(Client client, Car car);
}
