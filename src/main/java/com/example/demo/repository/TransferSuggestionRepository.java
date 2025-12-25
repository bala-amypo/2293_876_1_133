package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.example.demo.entity.TransferSuggestion;

public interface TransferSuggestionRepository
        extends JpaRepository<TransferSuggestion, Long> {

    List<TransferSuggestion> findByProduct_Id(Long productId);
}
