package io.bayrktlihn.photos.controller;


import io.bayrktlihn.photos.response.PhotoRest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("photos")
public class PhotosController {

    @GetMapping
    public List<PhotoRest> getPhotos() {
        List<PhotoRest> photoList = new ArrayList<>();
        photoList.add(new PhotoRest("albumIdHere", "1", "1", "Photo 1 title", "Photo 1 description", "Photo 1 URL"));
        photoList.add(new PhotoRest("albumIdHere", "2", "1", "Photo 2 title", "Photo 2 description", "Photo 2 URL"));
        return photoList;
    }

}
