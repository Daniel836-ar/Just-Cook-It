package org.example.service;

import org.example.model.Amount;
import org.example.repository.AmountRepository;
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
    // есть findAll() - вернёт список всех Amount

    public List<Amount> getAll() {
        return amountRepository.findAll();
    }
}
