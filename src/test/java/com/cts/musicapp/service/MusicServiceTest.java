package com.cts.musicapp.service;

import com.cts.musicapp.model.*;
import com.cts.musicapp.proxy.MusicProxy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MusicServiceTest {

    @Mock
    private MusicProxy mockMusicProxy;

    @InjectMocks
    private MusicService musicServiceUnderTest;

    @Test
    void testSearchMusic() {

        TracksResult expectedResult = new TracksResult();
        expectedResult.setHref("href");
        TrackResult trackResult = new TrackResult();
        AlbumResult album = new AlbumResult();
        Image image = new Image();
        image.setUrl("url");
        album.setImages(List.of(image));
        trackResult.setAlbum(album);
        expectedResult.setItems(List.of(trackResult));

        TracksResult tracksResult = new TracksResult();
        tracksResult.setHref("href");
        TrackResult trackResult1 = new TrackResult();
        AlbumResult album1 = new AlbumResult();
        Image image1 = new Image();
        image1.setUrl("url");
        album1.setImages(List.of(image1));
        trackResult1.setAlbum(album1);
        tracksResult.setItems(List.of(trackResult1));
        when(mockMusicProxy.searchMusicTracks("trackName", "limit")).thenReturn(tracksResult);
        TracksResult result = musicServiceUnderTest.searchMusic("trackName", "limit");

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testAddToWishList() {

        WishList wishList = new WishList();
        wishList.setId("id");
        wishList.setTrackName("trackName");
        wishList.setArtistName("artistName");

        WishList wishList1 = new WishList();
        wishList1.setId("id");
        wishList1.setTrackName("trackName");
        wishList1.setArtistName("artistName");
        when(mockMusicProxy.addToWishList(wishList1)).thenReturn("result");

        Object result = musicServiceUnderTest.addToWishList(wishList);

    }

    @Test
    void testGetFromWishList() {

        when(mockMusicProxy.getFromWishlist("id")).thenReturn("result");


        Object result = musicServiceUnderTest.getFromWishList("id");

    }

    @Test
    void testDeleteFromWishList() {

        when(mockMusicProxy.deleteFromWishlist("id")).thenReturn("result");

        String result = musicServiceUnderTest.deleteFromWishList("id");

        assertThat(result).isEqualTo("result");
    }
}
