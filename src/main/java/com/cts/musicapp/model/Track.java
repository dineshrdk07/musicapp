package com.cts.musicapp.model;

import lombok.Data;

import java.util.List;

@Data
public class Track {
    private Album album;
    private List<Artist> artists;
    private List<String> available_markets;
    private Integer disc_number;
    private Integer duration_ms;
    private Boolean explicit;
    private ExternalIds external_ids;
    private ExternalUrls external_urls;
    private String href;
    private String Id;
    private Boolean is_playable;
    private Object linked_from;
    private Restrictions restrictions;
    private String name;
    private String popularity;
    private String preview_url;
    private Integer track_number;
    private String type;
    private String uri;
    private Boolean is_local;
}
