package com.cts.musicapp.model;

import lombok.Data;

import java.util.List;
@Data
public class Tracks {
    private String href;
    private Integer limit;
    private String next;
    private Integer offset;
    private String previous;
    private Integer total;
    private List<Track> items;

}
