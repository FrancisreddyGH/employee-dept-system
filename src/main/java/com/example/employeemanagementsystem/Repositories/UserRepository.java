package com.example.employeemanagementsystem.Repositories;

import com.example.employeemanagementsystem.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
