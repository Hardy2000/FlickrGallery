package com.hardy.flickrgallery;

import com.hardy.flickrgallery.Models.RecentPhotos;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api_Interface {

    @GET("?method=flickr.photos.getRecent&per_page=20&page=1&format=json&nojsoncallback=1&extras=url_s")
    Call<RecentPhotos> getRecentPhotos(
            @Query("api_key") String apikey
    );
}
