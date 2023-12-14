package com.cts.musicapp.proxy;

import com.cts.musicapp.mapper.MusicMapper;
import com.cts.musicapp.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@Configurable
public class MusicProxy {
    @Autowired
    private MusicMapper musicMapper;
    private RestTemplate restTemplate = new RestTemplate();
    @Value("${musicapp.auth}")
    private String authUri;
    @Value("${musicapp.baseuri}")
    private String musicUri;
    @Value("${musicapp.clientid}")
    public String client_id;
    @Value("${musicapp.clientsecret}")
    public String client_secret;
    @Value("${wishlist.baseuri}")
    public String wishListUri;
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
    public TracksResult searchMusicTracks(String trackName, String limit){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization","Bearer  "+getAuthorization());
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity request = new HttpEntity(headers);
        Map<String, String> var = new HashMap<>();
        var.put("track",trackName);
        var.put("limit",limit);
        ResponseEntity<Object> response =  restTemplate.exchange(musicUri+"/v1/search?q={track}&type=track&limit={limit}",HttpMethod.GET,request,Object.class,var);
        SearchResponse result = mapper.convertValue(response.getBody(), SearchResponse.class);
        TracksResult tr = musicMapper.mapToTrackResult(result);
        return tr;
    }

    public Object addToWishList(WishList wishList){
        HttpEntity<WishList> request = new HttpEntity<>(wishList);
        Object res = restTemplate.exchange(wishListUri+"/create",HttpMethod.POST,request,Object.class);
        return res;
    }

    public Object getFromWishlist(String id){
        Object res = restTemplate.getForObject(wishListUri+"/search/{id}",Object.class,id);
        return res;
    }

    public String deleteFromWishlist(String id){
         restTemplate.delete(wishListUri+"/delete/{id}", id);
         return "deleted";
    }



}
