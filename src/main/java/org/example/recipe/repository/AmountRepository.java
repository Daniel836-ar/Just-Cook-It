package org.example.recipe.repository;

import org.example.recipe.model.Amount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmountRepository extends JpaRepository<Amount, Long> {
    //List<Amount> findAll();
}
