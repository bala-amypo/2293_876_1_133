// package com.example.demo.controller;

// import java.util.List;
// import org.springframework.web.bind.annotation.*;
// import com.example.demo.entity.TransferSuggestion;
// import com.example.demo.service.TransferSuggestionService;

// @RestController
// @RequestMapping("/api/transfers")
// public class TransferSuggestionController {

//     private final TransferSuggestionService service;

//     public TransferSuggestionController(
//             TransferSuggestionService service) {
//         this.service = service;
//     }

//     @PostMapping
//     public TransferSuggestion create(
//             @RequestBody TransferSuggestion suggestion) {
//         return service.createSuggestion(suggestion);
//     }

//     @GetMapping("/product/{productId}")
//     public List<TransferSuggestion> byProduct(
//             @PathVariable Long productId) {
//         return service.getSuggestionsByProduct(productId);
//     }
// }
