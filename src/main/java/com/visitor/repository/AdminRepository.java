package com.visitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.visitor.entity.Admin;


public interface AdminRepository extends JpaRepository<Admin, Long> {
}
