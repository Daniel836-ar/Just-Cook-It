package org.example.repository;

import org.example.model.Amount;
import org.example.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AmountRepository extends JpaRepository<Amount, Long> {
    List<Amount> findAll();
}
