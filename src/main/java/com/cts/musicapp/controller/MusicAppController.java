package com.cts.musicapp.controller;

import com.cts.musicapp.model.AuthResponse;
import com.cts.musicapp.model.Track;
import com.cts.musicapp.service.MusicService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/musicapp/v1")
@Controller
public class MusicAppController {
    @Value("${musicapp.baseuri}")
    private String musicbaseuri;
    @Autowired
    private MusicService musicService;

    @GetMapping("/getTracks")
     public ResponseEntity<Track> getTracks(){
       Track response = musicService.getTrack();
       return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @GetMapping("/getAuth")
    public ResponseEntity<String> getAuth(){
        String token = musicService.getAuthToken();
        return new ResponseEntity<>(token, HttpStatus.OK);
    }
}
