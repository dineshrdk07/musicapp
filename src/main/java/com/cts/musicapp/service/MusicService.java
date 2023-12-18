package com.cts.musicapp.service;

import com.cts.musicapp.model.*;
import com.cts.musicapp.proxy.MusicProxy;
import com.cts.musicapp.proxy.MusicProxys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
@Service
public class MusicService {
    @Autowired
    private MusicProxy musicProxy;
    @Autowired
    private MusicProxys musicProxys;
    public TracksResult searchMusic(String trackName, String limit){return  musicProxy.searchMusicTracks(trackName,limit);}
    public Object addToWishList(WishList wishList){return musicProxys.saveTrack(wishList);};
}
