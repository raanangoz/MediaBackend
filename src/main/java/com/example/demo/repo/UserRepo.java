package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Media;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import com.example.demo.model.User;

public interface UserRepo extends JpaRepository<User, Long> {

}
