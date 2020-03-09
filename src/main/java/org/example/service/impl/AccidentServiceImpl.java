package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.Accident;
import org.example.entity.Contract;
import org.example.repository.AccidentRepository;
import org.example.service.AccidentService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class AccidentServiceImpl implements AccidentService {
    private final AccidentRepository accidentRepository;

    @Transactional
    @Override
    public Accident findById(Long id) {
        Accident accident = accidentRepository.findById(id)
                .orElseThrow(() -> new ServiceException(String.format("There is no accident with %s", id)));
        log.info("Find accident with id " + id);
        return accident;
    }

    @Transactional
    @Override
    public List<Accident> findAll() {
        return accidentRepository.findAll();
    }

    @Transactional
    @Override
    public Accident save(Contract contract, Date dateOfAccident, Double costOfDamage) {
        Accident accident = new Accident();
        accident.setContract(contract);
        dateOfAccident.setDate(dateOfAccident.getDate() + 1);
        accident.setDateOfAccident(dateOfAccident);
        accident.setCostOfDamage(costOfDamage);
        log.info("Successfully adding new accident");
        return accidentRepository.save(accident);
    }

    @Transactional
    @Override
    public Accident update(Long id, Contract contract, Date dateOfAccident, Double costOfDamage) {
        return accidentRepository.findById(id)
                .map(accident -> {
                    accident.setContract(contract);
                    dateOfAccident.setDate(dateOfAccident.getDate() + 1);
                    accident.setDateOfAccident(dateOfAccident);
                    accident.setCostOfDamage(costOfDamage);
                    accidentRepository.save(accident);
                    log.info("Update car with id " + id);
                    return accident;
                }).orElseThrow(() -> new IllegalArgumentException(String.format("There is no accident with such id %s", id)));
    }

    @Transactional
    @Override
    public void remove(Long id) {
        accidentRepository.deleteById(id);
        log.info("Delete car with id " + id);
    }

    @Transactional
    @Override
    public List<Accident> findAccidentByContract(Contract contract) {
        return accidentRepository.findAccidentByContract(contract);
    }

}
