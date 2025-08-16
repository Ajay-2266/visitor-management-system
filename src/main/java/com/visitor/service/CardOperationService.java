package com.visitor.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.visitor.repository.CardOperationRepository;
import com.visitor.entity.CardOperation;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardOperationService {
	
	 private final CardOperationRepository cardOperationRepository;
	 
	 public CardOperation perform(String cardNumber, String operation){
		 CardOperation c = CardOperation.builder().cardNumber(cardNumber).operation(operation).timestamp(LocalDateTime.now()).build();
		 return cardOperationRepository.save(c);
	 }
	 public List<CardOperation> getAll(){ 
		 return cardOperationRepository.findAll(); 
	 }
	 public CardOperation create(CardOperation card) {
	        return cardOperationRepository.save(card);
	    }
}
