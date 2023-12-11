package com.cts.musicapp.model;

import lombok.Data;

import java.util.List;

@Data
public class Album {
    private String album_type;
    private Integer total_tracks;
    private List<String> available_markets;
    private ExternalUrls external_urls;
    private String id;
    private String href;
    private List<Image> images;
    private String name;
    private String release_date;
    private String release_date_precision;
    private Restrictions restrictions;
    private String type;
    private String uri;
    private List<SimpleArtist> artists;
}
