package com.visitor.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.visitor.repository.AdminRepository;
import com.visitor.entity.Admin;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {
	
	private final AdminRepository adminRepository;
	
	public Admin create(Admin a) {
		return adminRepository.save(a); 
	}
	public List<Admin> getAll(){
		return adminRepository.findAll(); 
	}
	public Admin getById(Long id){ 
		return adminRepository.findById(id).orElseThrow(()->new RuntimeException("Admin not found"));
	}
	public Admin update(Long id, Admin a){ 
		Admin ex = getById(id); ex.setRole(a.getRole()); 
		ex.setPassword(a.getPassword());
		ex.setUsername(a.getUsername()); 
		return adminRepository.save(ex); 
	}
	public void delete(Long id){ 
		adminRepository.deleteById(id); 
	}
}
