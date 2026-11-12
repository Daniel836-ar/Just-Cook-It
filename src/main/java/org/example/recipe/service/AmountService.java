package org.example.recipe.service;

import org.example.recipe.model.Amount;
import org.example.recipe.repository.AmountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmountService {
    @Autowired
    private AmountRepository amountRepository;

    AmountService(AmountRepository amountRepository) {
        this.amountRepository = amountRepository;
    }

    public List<Amount> getAll() {
        return amountRepository.findAll();
    }
}
