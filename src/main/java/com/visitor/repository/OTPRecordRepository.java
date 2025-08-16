package com.visitor.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.visitor.entity.OTPRecord;

public interface OTPRecordRepository extends JpaRepository<OTPRecord, Long> {

	Optional<OTPRecord> findTopByPhoneOrderByCreatedAtDesc(String phone);

	
}
