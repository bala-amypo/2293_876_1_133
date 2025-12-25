package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.TransferSuggestion;
import com.example.demo.repository.TransferSuggestionRepository;
import com.example.demo.service.TransferSuggestionService;

@Service
public class TransferSuggestionServiceImpl
        implements TransferSuggestionService {

    private final TransferSuggestionRepository repository;

    public TransferSuggestionServiceImpl(
            TransferSuggestionRepository repository) {
        this.repository = repository;
    }

    @Override
    public TransferSuggestion createSuggestion(
            TransferSuggestion suggestion) {
        return repository.save(suggestion);
    }

    @Override
    public List<TransferSuggestion> getSuggestionsByProduct(
            Long productId) {
        return repository.findByProduct_Id(productId);
    }
}
