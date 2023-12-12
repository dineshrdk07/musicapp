package com.cts.musicapp.controller;

import com.cts.musicapp.model.AuthResponse;
import com.cts.musicapp.model.SearchResponse;
import com.cts.musicapp.model.Track;
import com.cts.musicapp.service.MusicService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/musicapp/v1")
@Controller
public class MusicAppController {
    @Value("${musicapp.baseuri}")
    private String musicbaseuri;
    @Autowired
    private MusicService musicService;

    @GetMapping("/search/{trackName}/{limit}")
    public ResponseEntity<SearchResponse> getAuth(@PathVariable("trackName") String trackName,@PathVariable("limit") String limit){
        SearchResponse res = musicService.searchMusic(trackName,limit);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
