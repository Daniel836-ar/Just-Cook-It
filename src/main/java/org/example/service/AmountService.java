package org.example.service;

import org.example.repository.AmountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AmountService {
    @Autowired
    private AmountRepository amountRepository;
    AmountService(AmountRepository amountRepository){
        this.amountRepository = amountRepository;
    }
    // есть findAll() - вернёт список всех Amount
}
