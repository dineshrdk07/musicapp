package com.cts.musicapp.model;

import lombok.Data;

@Data
public class AuthResponse {
    private String access_token;
    private String token_type;
    private String expires_in;
}
