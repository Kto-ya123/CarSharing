package org.example.repository;

import org.example.entity.Accident;
import org.example.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccidentRepository extends JpaRepository<Accident, Long> {
    List<Accident> findAccidentByContract(Contract contract);
}
