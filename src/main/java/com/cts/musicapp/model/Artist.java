package com.cts.musicapp.model;

import lombok.Data;

import java.util.List;
@Data
public class Artist {
    private ExternalUrls external_urls;
    private Followers followers;
    private List<String> genres;
    private String href;
    private String id;
    private List<Image> images;
    private String name;
    private Integer popularity;
    private String type;
    private String uri;

}
