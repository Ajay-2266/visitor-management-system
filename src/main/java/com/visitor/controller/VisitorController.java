package com.visitor.controller;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import com.visitor.service.VisitorService;

import com.visitor.entity.Visitor;

import java.util.List;

@RestController
@RequestMapping("/api/visitors")
@RequiredArgsConstructor
public class VisitorController {
	 private final VisitorService visitorService;
	 
	 
	 @PostMapping
	 public Visitor register(@RequestBody Visitor v){ 
		 return visitorService.create(v); 
	 }
	 @GetMapping
	 public List<Visitor> all(){ 
		 return visitorService.getAll(); 
	 }
	 @GetMapping("/{id}")
	 public Visitor get(@PathVariable Long id){ 
		 return visitorService.getById(id); 
	 }
	 @PutMapping("/{id}")
	 public Visitor update(@PathVariable Long id,@RequestBody Visitor v){ 
		 return visitorService.update(id,v); 
	 }
	 @DeleteMapping("/{id}")
	 public void delete(@PathVariable Long id){ 
		 visitorService.delete(id); 
	 }
	 
}
