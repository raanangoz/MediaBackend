package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Media;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MediaRepo extends JpaRepository<Media, Long> {
    void deleteMediaById(int id);

    Optional<Media> findMediaByName(String name);

}
