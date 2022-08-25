package io.bayrktlihn.albums.controller;

import io.bayrktlihn.albums.response.AlbumRest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("albums")
public class AlbumsController {
    @GetMapping
    public List<AlbumRest> getAlbums() {
        List<AlbumRest> albums = new ArrayList<>();
        albums.add(new AlbumRest("albumIdHere", "1", "Album 1 title", "Album 1 description", "Album 1 URL"));
        albums.add(new AlbumRest("albumIdHere", "2", "Album 2 title", "Album 2 description", "Album 2 URL"));

        return albums;
    }
}
