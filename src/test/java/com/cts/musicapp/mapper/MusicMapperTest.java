package com.cts.musicapp.mapper;

import com.cts.musicapp.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MusicMapperTest {

    private MusicMapper musicMapperUnderTest;

    @BeforeEach
    void setUp() {
        musicMapperUnderTest = new MusicMapper();
    }

    @Test
    void testMapToTrackResult() {
        SearchResponse track = new SearchResponse();
        Tracks tracks = new Tracks();
        tracks.setHref("href");
        Track track1 = new Track();
        Album album = new Album();
        Image image = new Image();
        album.setImages(List.of(image));
        album.setName("name");
        SimpleArtist simpleArtist = new SimpleArtist();
        simpleArtist.setName("name");
        album.setArtists(List.of(simpleArtist));
        track1.setAlbum(album);
        track1.setDuration_ms(0);
        track1.setHref("href");
        track1.setId("Id");
        track1.setName("name");
        track1.setPreview_url("preview_url");
        track1.setType("type");
        track1.setUri("uri");
        tracks.setItems(List.of(track1));
        track.setTracks(tracks);

        TracksResult expectedResult = new TracksResult();
        expectedResult.setHref("href");
        TrackResult trackResult = new TrackResult();
        AlbumResult album1 = new AlbumResult();
        Image image1 = new Image();
        album1.setImages(List.of(image1));
        album1.setName("name");
        SimpleArtistResult simpleArtistResult = new SimpleArtistResult();
        simpleArtistResult.setName("name");
        album1.setArtists(List.of(simpleArtistResult));
        trackResult.setAlbum(album1);
        trackResult.setDuration_ms(0);
        trackResult.setHref("href");
        trackResult.setId("Id");
        trackResult.setName("name");
        trackResult.setPreview_url("preview_url");
        trackResult.setType("type");
        trackResult.setUri("uri");
        expectedResult.setItems(List.of(trackResult));


        TracksResult result = musicMapperUnderTest.mapToTrackResult(track);

        assertEquals(result,expectedResult);
    }


}
