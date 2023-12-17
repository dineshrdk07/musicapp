package com.cts.musicapp.controller;

import com.cts.musicapp.model.*;
import com.cts.musicapp.service.MusicService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MusicAppController.class)
class MusicAppControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MusicService mockMusicService;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void testGetTrack() throws Exception {

        TracksResult tracksResult = new TracksResult();
        tracksResult.setHref("href");
        TrackResult trackResult = new TrackResult();
        AlbumResult album = new AlbumResult();
        album.setName("name");
        Image image = new Image();
        image.setUrl("url");
        album.setImages(List.of(image));
        trackResult.setAlbum(album);
        tracksResult.setItems(List.of(trackResult));
        when(mockMusicService.searchMusic("trackName", "limit")).thenReturn(tracksResult);


        MockHttpServletResponse response = mockMvc.perform(
                get("/musicapp/v1/search/{trackName}/{limit}", "trackName", "limit")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();


        assertEquals(response.getStatus(),HttpStatus.OK.value());
    }

    @Test
    void testAddToWishList() throws Exception {

        WishList wishList = new WishList();
        wishList.setId("id");
        wishList.setTrackName("trackName");
        wishList.setArtistName("artistName");
        when(mockMusicService.addToWishList(wishList)).thenReturn(wishList);


        String requestBody = mapper.writeValueAsString(wishList);
        MockHttpServletResponse response = mockMvc.perform(post("/musicapp/v1/addtowishlist")
                .content(requestBody).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();



        assertEquals(response.getStatus(), HttpStatus.OK.value());

    }
    @Test
    void testGetFromWishList() throws Exception {

        when(mockMusicService.getFromWishList("id")).thenReturn("body");

        MockHttpServletResponse response = mockMvc.perform(get("/musicapp/v1/wishlist/search/{id}", "id")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertEquals(response.getStatus(), HttpStatus.OK.value());
    }

    @Test
    void testDeleteFromWishlist() throws Exception {

        when(mockMusicService.deleteFromWishList("id")).thenReturn("body");

        MockHttpServletResponse response = mockMvc.perform(delete("/musicapp/v1/wishlist/delete/{id}", "id")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertEquals(response.getStatus(), HttpStatus.OK.value());
    }
}
