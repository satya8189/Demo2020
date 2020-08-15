package com.example.resumeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.resumeapi.entity.ApplicationUser;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    ApplicationUser findByUsername(String username);
}