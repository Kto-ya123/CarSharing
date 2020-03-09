package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.Client;
import org.example.repository.AccidentRepository;
import org.example.repository.ClientRepository;
import org.example.repository.ContractRepository;
import org.example.service.ClientService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ContractRepository contractRepository;
    private final AccidentRepository accidentRepository;

    @Transactional
    @Override
    public Client findById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ServiceException(String.format("There is no client with %s", id)));
        log.info("Find client with id " + id);
        return client;
    }

    @Transactional
    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Transactional
    @Override
    public Client save(String name, String surname, String patronymic, Integer experience,
                       String address, String phone, String passport) {
        Optional<Client> exitClient = clientRepository.findClientByPassport(passport);
        if (exitClient.isPresent()) {
            throw new ServiceException(String.format("Client with this passport data has already exist"));
        }
        Client client = new Client();
        client.setName(name);
        client.setSurname(surname);
        client.setPatronymic(patronymic);
        client.setAddress(address);
        client.setExperience(experience);
        client.setPassport(passport);
        client.setPhoneNumber(phone);
        log.info("Successfully adding new client");
        return clientRepository.save(client);
    }

    @Transactional
    @Override
    public Client update(Long id, String name, String surname, String patronymic,
                         Integer experience, String address, String phone, String passport) {
        return clientRepository.findById(id)
                .map(client -> {
                    client.setSurname(surname);
                    client.setName(name);
                    client.setPatronymic(patronymic);
                    client.setAddress(address);
                    client.setExperience(experience);
                    client.setPassport(passport);
                    client.setPhoneNumber(phone);
                    clientRepository.save(client);
                    log.info("Update client with id " + id);
                    return client;
                }).orElseThrow(() -> new IllegalArgumentException(String.format("There is no client with such id %s", id)));
    }

    @Transactional
    @Override
    public void remove(Long id) {
        contractRepository.findContractByClient(clientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(String.format("There is no car with id %s", id)))).
                forEach(contract -> {
                    contractRepository.delete(contract);
                    accidentRepository.deleteAll(accidentRepository.findAccidentByContract(contract));
                });
        clientRepository.deleteById(id);
        log.info("Delete client with id " + id);
    }

    @Transactional
    @Override
    public Optional<Client> findClientByPassport(String passport) {
        return clientRepository.findClientByPassport(passport);
    }
}
