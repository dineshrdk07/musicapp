package com.cts.musicapp.mapper;

import com.cts.musicapp.model.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class MusicMapper {
    public TracksResult mapToTrackResult(SearchResponse track){
        if(track ==null){
            return null;
        }
        List<TrackResult> trackResultList = new ArrayList<>();
        Tracks tracksRes = track.getTracks();
        TracksResult tracksResult = new TracksResult();
        tracksResult.setHref(tracksRes.getHref());
        tracksRes.getItems().forEach(items->{
            TrackResult tr = new TrackResult();
            AlbumResult al = new AlbumResult();
            List<SimpleArtistResult> simpleArtistResultList = new ArrayList<>();
            tr.setId(items.getId());
            tr.setHref(items.getHref());
            tr.setName(items.getName());
            tr.setUri(items.getUri());
            tr.setPreview_url(items.getPreview_url());
            tr.setType(items.getType());
            tr.setDuration_ms(items.getDuration_ms());
            al.setName(items.getAlbum().getName());
            al.setImages(items.getAlbum().getImages());
            items.getAlbum().getArtists().forEach(simpleArtist -> {
                SimpleArtistResult simpleArtistResult = new SimpleArtistResult();
                simpleArtistResult.setName(simpleArtist.getName());
                simpleArtistResultList.add(simpleArtistResult);
            });
            al.setArtists(simpleArtistResultList);
            tr.setAlbum(al);
            trackResultList.add(tr);
        });
        tracksResult.setItems(trackResultList);
        return tracksResult;
    }
}
