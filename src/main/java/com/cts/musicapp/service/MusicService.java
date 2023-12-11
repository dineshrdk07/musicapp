package com.cts.musicapp.service;

import com.cts.musicapp.model.Album;
import com.cts.musicapp.model.AuthResponse;
import com.cts.musicapp.model.Track;
import com.cts.musicapp.proxy.MusicProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
@Service
public class MusicService {
    @Autowired
    private MusicProxy musicProxy;

    private Album getTracks(){
     return null;
    }
    public String getAuthToken(){
        return musicProxy.getAuthorization();
    }
    public Track getTrack(){
        return musicProxy.getTracks();
    }
}
