package com.cts.musicapp.model;

import lombok.Data;

import java.util.List;

@Data
public class TracksResult {
    private String href;
    List<TrackResult> items;
}
