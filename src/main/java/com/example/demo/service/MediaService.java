package com.example.demo.service;

import com.example.demo.exception.MediaAlreadyExistException;
import com.example.demo.exception.MediaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Media;
import com.example.demo.repo.MediaRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MediaService {
    private final MediaRepo mediaRepo;

    @Autowired
    public MediaService(MediaRepo MediaRepo) {
        this.mediaRepo = MediaRepo;
    }

    public Media addMedia(Media media) {
        return mediaRepo.save(media);
    }

    public List<Media> findAllMedias() {
        return mediaRepo.findAll();
    }

    public Media updateMedia(Media media) {
        return mediaRepo.save(media);
    }

    public Media findMediaByName(String name) {
        return mediaRepo.findMediaByName(name)
                .orElseThrow(() -> new MediaNotFoundException(name));
    }
//    public Media custonFindAuth(String name) {
//        return MediaRepo.custonFindAuth(name)
//                .orElseThrow(() -> new MediaNotFoundException("Media was not found"));
//    }

    public void deleteMediaById(int id){
        mediaRepo.deleteMediaById(id);
    }
}
