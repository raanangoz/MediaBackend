package com.example.demo.service;

import com.example.demo.exception.MediaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.example.demo.model.Media;
import com.example.demo.repo.MediaRepo;

import javax.transaction.Transactional;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Service
@Transactional
public class MediaService {
    private final MediaRepo MediaRepo;

    @Autowired
    public MediaService(MediaRepo MediaRepo) {
        this.MediaRepo = MediaRepo;
    }

    public Media addMedia(Media media) throws Exception {
        try {
            return MediaRepo.save(media);
        }
        catch(Exception e){
            throw new Exception();
        }


    }

    public List<Media> findAllMedias() {
        return MediaRepo.findAll();
    }

    public Media updateMedia(Media media) {
        return MediaRepo.save(media);
    }

    public Media findMediaByName(String name) {
        return MediaRepo.findMediaByName(name)
                .orElseThrow(() -> new MediaNotFoundException(name));
    }
//    public Media custonFindAuth(String name) {
//        return MediaRepo.custonFindAuth(name)
//                .orElseThrow(() -> new MediaNotFoundException("Media was not found"));
//    }

    public void deleteMediaById(int id){
        MediaRepo.deleteMediaById(id);
    }
}
