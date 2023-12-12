package com.cts.musicapp.model;

import lombok.Data;

import java.util.List;

@Data
public class SimpleAudioBook {
    private List<Authors> authors;
    private List<String> available_markets;
    private List<Copyrights> copyrights;
    private String description;
    private String html_description;
    private String edition;
    private Boolean explicit;
    private ExternalUrls external_urls;
    private String href;
    private String id;
    private List<Image> images;
    private List<String> languages;
    private String media_type;
    private String name;
    private List<Narrator> narrators;
    private String publisher;
    private String type;
    private String uri;
    private Integer total_chapters;
}
