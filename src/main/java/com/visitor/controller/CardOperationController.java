package com.visitor.controller;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import com.visitor.service.CardOperationService;
import com.visitor.entity.CardOperation;
import java.util.List;

@RestController
@RequestMapping("/api/cards")
@RequiredArgsConstructor
public class CardOperationController {
	
	 private final CardOperationService cardOperationService;
	 
	 @PostMapping("/operate")
	 public CardOperation operate(@RequestParam String cardNumber,@RequestParam String op){ 
		 return cardOperationService.perform(cardNumber,op); 
	 }
	 @GetMapping
	 public List<CardOperation> all(){ 
		 return cardOperationService.getAll(); 
	 }
}
