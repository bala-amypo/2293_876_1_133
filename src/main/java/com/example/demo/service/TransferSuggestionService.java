package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.TransferSuggestion;

public interface TransferSuggestionService {

    TransferSuggestion createSuggestion(TransferSuggestion suggestion);

    List<TransferSuggestion> getSuggestionsByProduct(Long productId);
}
