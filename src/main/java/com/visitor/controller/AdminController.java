package com.visitor.controller;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import com.visitor.service.AdminService;
import com.visitor.entity.Admin;
import java.util.List;

@RestController
@RequestMapping("/api/admins")
@RequiredArgsConstructor
public class AdminController {
	 private final AdminService adminService;
	 @PostMapping
	 
	 public Admin create(@RequestBody Admin a){ 
		 return adminService.create(a);
	 }
	 @GetMapping
	 public List<Admin> all(){ 
		 return adminService.getAll(); 
	 }
	 @GetMapping("/{id}")
	 public Admin get(@PathVariable Long id){ 
		 return adminService.getById(id); 
	 }
	 @PutMapping("/{id}")
	 public Admin update(@PathVariable Long id, @RequestBody Admin a){ 
		 return adminService.update(id,a); 
	 }
	 @DeleteMapping("/{id}")
	 public void delete(@PathVariable Long id){ 
		 adminService.delete(id); 
	 }
}
