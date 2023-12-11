package com.cts.musicapp.model;

import org.springframework.beans.factory.annotation.Value;

public class AuthRequest {
    public String grant_type="client_credentials";
    @Value("${musicapp.clientid}")
    public String client_id;
    @Value("${musicapp.clientsecret}")
    public String client_secret;
}
