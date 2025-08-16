package com.visitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.visitor.entity.Admin;
import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
