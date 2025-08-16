package com.visitor.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.visitor.repository.VisitorRepository;
import com.visitor.entity.Visitor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitorService {
	private final VisitorRepository visitorRepository;
	public Visitor create(Visitor v){ 
		return visitorRepository.save(v); 
	}
	public List<Visitor> getAll(){ 
		return visitorRepository.findAll(); 
	}
	public Visitor getById(Long id){
		return visitorRepository.findById(id).orElseThrow(()->new RuntimeException("Visitor not found")); 
	}
	public Visitor update(Long id, Visitor v){ 
		Visitor ex = getById(id); 
		ex.setName(v.getName()); 
		ex.setEmail(v.getEmail());
		ex.setPhone(v.getPhone()); 
		
		return visitorRepository.save(ex); 
	}
	public void delete(Long id){ 
		visitorRepository.deleteById(id); 
	}
}
