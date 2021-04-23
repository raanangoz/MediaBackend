
package com.example.demo.resource;

import com.example.demo.exception.MediaAlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Media;
import com.example.demo.service.MediaService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("media/")
public class MediaResource {
    private final MediaService MediaService;

    public MediaResource(MediaService MediaService) {
        this.MediaService = MediaService;
    }

    @GetMapping("all")
    public ResponseEntity<List<Media>> getAllMedias () {
        List<Media> media = MediaService.findAllMedias();
        return new ResponseEntity<>(media, HttpStatus.OK);
    }

    @GetMapping("/findBook/{name}")
    public ResponseEntity<Media> getMediaByName (@PathVariable("name") String name) {
        Media media;
        media = MediaService.findMediaByName(name);
        return new ResponseEntity<>(media, HttpStatus.OK);

    }

    @PostMapping("/add")
    public ResponseEntity<Media> addMedia(@RequestBody Media media) throws Exception, MediaAlreadyExistException {
        Media newMedia = MediaService.addMedia(media);
        return new ResponseEntity<>(newMedia, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Media> updateMedia(@RequestBody Media media) {

//        Media updateMedia = MediaService.updateMedia(media);
        return new ResponseEntity<>(MediaService.updateMedia(media), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMedia(@PathVariable("id") int id) {
        MediaService.deleteMediaById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
