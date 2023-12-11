package com.cts.musicapp.model;

import lombok.Data;

@Data
public class SimpleArtist {
    private ExternalUrls external_urls;
    private String href;
    private String id;
    private String name;
    private String type;
    private String uri;
}
