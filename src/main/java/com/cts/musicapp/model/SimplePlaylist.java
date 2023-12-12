package com.cts.musicapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class SimplePlaylist {
    private boolean collaborative;
    private String description;
    private ExternalUrls external_urls;
    private String href;
    private String id;
    private List<Image> images;
    private String name;
    private Owner owner;
    @JsonProperty("public")
    private Boolean flag;
    private String snapshot_id;
    private Tracks tracks;
    private String type;
    private String uri;
}
