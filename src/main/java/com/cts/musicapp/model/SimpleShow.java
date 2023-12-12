package com.cts.musicapp.model;

import lombok.Data;

import java.util.List;

@Data
public class SimpleShow {
    private List<String> available_markets;
    private List<Copyrights> copyrights;
    private String description;
    private String html_description;
    private Boolean explicit;
    private ExternalUrls external_urls;
    private String href;
    private String id;
    private List<Image> images;
    private Boolean is_externally_hosted;
    private List<String> languages;
    private String media_type;
    private String name;
    private String publisher;
    private String type;
    private String uri;
    private Integer total_episodes;

}
