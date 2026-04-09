package org.example.repository;

import org.example.model.Amount;
import org.example.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AmountRepository extends JpaRepository<Amount, Long> {
    //List<Amount> findAll();
}
