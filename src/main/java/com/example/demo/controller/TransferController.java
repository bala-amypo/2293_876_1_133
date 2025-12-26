package com.example.demo.controller;

import com.example.demo.entity.TransferSuggestion;
import com.example.demo.service.TransferService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transfers")
public class TransferController {

    private final TransferService service;

    public TransferController(TransferService service) {
        this.service = service;
    }

    @PostMapping
    public TransferSuggestion create(@RequestBody TransferSuggestion suggestion) {
        return service.create(suggestion);
    }
}
