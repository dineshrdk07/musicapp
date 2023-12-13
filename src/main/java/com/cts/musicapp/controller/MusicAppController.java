package com.cts.musicapp.controller;

import com.cts.musicapp.model.*;
import com.cts.musicapp.service.MusicService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/musicapp/v1")
@Controller
public class MusicAppController {
    @Value("${musicapp.baseuri}")
    private String musicbaseuri;
    @Autowired
    private MusicService musicService;

    @GetMapping("/search/{trackName}/{limit}")
    public ResponseEntity<TracksResult> getTrack(@PathVariable("trackName") String trackName, @PathVariable("limit") String limit){
        TracksResult res = musicService.searchMusic(trackName,limit);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/addtowishlist")
    public ResponseEntity<Object> addToWishList(@RequestBody WishList wishList){
         Object res = musicService.addToWishList(wishList);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
