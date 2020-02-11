package org.example.repository;

import org.example.entity.Accident;
import org.example.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccidentRepository extends JpaRepository<Accident, Long> {
    List<Accident> findAccidentByContract(Contract contract);
}
