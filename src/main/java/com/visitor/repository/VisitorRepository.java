package com.visitor.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.visitor.entity.Visitor;

public interface VisitorRepository extends JpaRepository<Visitor, Long> {

	

}
