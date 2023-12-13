package com.cts.musicapp.model;

import lombok.Data;

import java.util.List;

@Data
public class TrackResult {
    private AlbumResult album;
    private Integer duration_ms;
    private String href;
    private String Id;
    private String name;
    private String preview_url;
    private String type;
    private String uri;
}
