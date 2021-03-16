package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.Media;
import com.example.demo.repo.MediaRepo;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MediaService {
    private final MediaRepo MediaRepo;

    @Autowired
    public MediaService(MediaRepo MediaRepo) {
        this.MediaRepo = MediaRepo;
    }

    public Media addMedia(Media media) {
//        Media.setMediaCode(UUID.randomUUID().toString());
        return MediaRepo.save(media);
    }

    public List<Media> findAllMedias() {
        return MediaRepo.findAll();
    }

    public Media updateMedia(Media media) {
        return MediaRepo.save(media);
    }

    public Media findMediaByName(String name) {
        return MediaRepo.findMediaByName(name)
                .orElseThrow(() -> new UserNotFoundException("Media was not found"));
    }
    public Media custonFindAuth(String name) {
        return MediaRepo.custonFindAuth(name)
                .orElseThrow(() -> new UserNotFoundException("Media was not found"));
    }

    public void deleteMedia(Long id){
        MediaRepo.deleteMediaById(id);
    }
}
