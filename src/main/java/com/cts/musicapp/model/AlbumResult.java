package com.cts.musicapp.model;

import lombok.Data;

import java.util.List;

@Data
public class AlbumResult {
    private List<Image> images;
    private String name;
    private List<SimpleArtistResult> artists;
}
