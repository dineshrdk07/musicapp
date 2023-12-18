package com.cts.musicapp.proxy;

import com.cts.musicapp.model.WishList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="WISHLIST")
public interface MusicProxys {
    @PostMapping("/wishlist/v1/create")
    WishList saveTrack(WishList wishlist);
}
