package com.cts.musicapp.model;

import lombok.Data;

@Data
public class Owner {
    private ExternalUrls external_urls;
    private Followers followers;
    private String href;
    private String id;
    private String type;
    private String uri;
    private String display_name;
}
