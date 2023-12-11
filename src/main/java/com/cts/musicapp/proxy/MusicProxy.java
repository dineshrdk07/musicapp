package com.cts.musicapp.proxy;

import com.cts.musicapp.model.Album;
import com.cts.musicapp.model.AuthRequest;
import com.cts.musicapp.model.AuthResponse;
import com.cts.musicapp.model.Track;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.function.EntityResponse;

import java.lang.reflect.Type;
import java.net.URI;
import java.util.*;

@Service
@Configurable
public class MusicProxy {
    private RestTemplate restTemplate = new RestTemplate();
    @Value("${musicapp.auth}")
    private String authUri;
    @Value("${musicapp.baseuri}")
    private String musicUri;
    @Value("${musicapp.clientid}")
    public String client_id;
    @Value("${musicapp.clientsecret}")
    public String client_secret;

    @Value("${musicapp.track.kangaledho}")
    public String trackId;
    @Autowired
    private ObjectMapper mapper;

    public String getAuthorization(){
        MultiValueMap<String,String> param = new LinkedMultiValueMap<>();
        param.add("grant_type","client_credentials");
        param.add("client_id",client_id);
        param.add("client_secret",client_secret);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String,String>> request = new HttpEntity<>(param,headers);
        AuthResponse authResponse = restTemplate.postForObject(authUri,request,AuthResponse.class);
        return authResponse.getAccess_token();
    }
    public Object searchMusicTracks(String trackName){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization","Bearer  "+getAuthorization());
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<Object> response =  restTemplate.exchange(musicUri+"/v1/search?q={track}&type=track",HttpMethod.GET,request,Object.class,trackName);
        return response.getBody();

    }
}
