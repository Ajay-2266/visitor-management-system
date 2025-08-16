package com.visitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.visitor.entity.CardOperation;

public interface CardOperationRepository extends JpaRepository<CardOperation, Long> {

}
