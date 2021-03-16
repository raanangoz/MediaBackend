package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Media;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MediaRepo extends JpaRepository<Media, Long> {
    void deleteMediaById(Long id);

    Optional<Media> findMediaByName(String name);

    @Query("SELECT p FROM Media p WHERE LOWER(p.author) = LOWER(:name)")
    Optional<Media> custonFindAuth(String name);
}
