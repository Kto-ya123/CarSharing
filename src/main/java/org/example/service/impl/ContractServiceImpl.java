package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.Car;
import org.example.entity.Client;
import org.example.entity.Contract;
import org.example.repository.ContractRepository;
import org.example.service.ContractService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class ContractServiceImpl implements ContractService {
    private final ContractRepository contractRepository;

    @Transactional
    @Override
    public Contract findById(Long id) {
        Contract contract = contractRepository.findById(id)
                .orElseThrow(() -> new ServiceException(String.format("There is no contract with %s", id)));
        log.info("Find contract with id " + id);
        return contract;
    }

    @Transactional
    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Transactional
    @Override
    public Contract save(Car car, Client client, Date dateOfStart, Date dateOfEnd) {
        Contract contract = new Contract();
        contract.setCar(car);
        contract.setClient(client);
        contract.setDateOfStart(dateOfStart);
        contract.setDateOfEnd(dateOfEnd);
        Long timeInDay = ((dateOfEnd.getTime() - dateOfStart.getTime()) / 1000 / 3600 / 24) + 1;
        Double totalCost = car.getPrice() * timeInDay;
        contract.setTotalCost(totalCost);
        log.info("Successfully adding new contract");
        return contractRepository.save(contract);
    }

    @Transactional
    @Override
    public Contract update(Long id, Car car, Client client, Date dateOfStart, Date dateOfEnd) {
        return contractRepository.findById(id)
                .map(contract -> {
                    contract.setCar(car);
                    contract.setClient(client);
                    dateOfStart.setDate(dateOfStart.getDate() + 1);
                    contract.setDateOfStart(dateOfStart);
                    dateOfEnd.setDate(dateOfEnd.getDate() + 1);
                    contract.setDateOfEnd(dateOfEnd);
                    Long timeInDay = (dateOfEnd.getTime() - dateOfStart.getTime()) / 1000 / 3600 / 24;
                    Double totalCost = car.getPrice() * timeInDay;
                    contract.setTotalCost(totalCost);
                    contractRepository.save(contract);
                    log.info("Update client with id " + id);
                    return contract;
                }).orElseThrow(() -> new IllegalArgumentException(String.format("There is no contract with such id %s", id)));
    }

    @Transactional
    @Override
    public void remove(Long id) {
        contractRepository.deleteById(id);
        log.info("Delete client with id " + id);
    }

    @Transactional
    @Override
    public List<Contract> findContractByClient(Client client) {
        return contractRepository.findContractByClient(client);
    }

    @Transactional
    @Override
    public List<Contract> findContractByCar(Car car) {
        return contractRepository.findContractByCar(car);
    }
}
