package com.cts.musicapp.model;

import lombok.Data;

@Data
public class Episodes {
    private String href;
    private Integer limit;
    private String next;
    private Integer offset;
    private String previous;
    private Integer total;
    private Episode episode;

}
