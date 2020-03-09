package org.example.service;

import org.example.entity.Accident;
import org.example.entity.Contract;

import java.util.Date;
import java.util.List;


public interface AccidentService {
    Accident findById(Long id);

    List<Accident> findAll();

    Accident save(Contract contract,
                  Date dateOfAccident,
                  Double costOfDamage);

    Accident update(Long id,
                    Contract contract,
                    Date dateOfAccident,
                    Double costOfDamage);

    void remove(Long id);

    List<Accident> findAccidentByContract(Contract contract);
}
