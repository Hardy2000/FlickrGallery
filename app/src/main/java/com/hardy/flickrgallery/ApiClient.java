package com.hardy.flickrgallery;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String BASE_URL="https://api.flickr.com/services/rest/";
    //   &api_key=6f102c62f41998d151e5a1b48713cf13



    private static ApiClient apiClient;
    private static Retrofit retrofit;

    private ApiClient()
    {
        retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static synchronized ApiClient getInstance(){
        if(apiClient==null)
        {
            apiClient=new ApiClient();
        }
        return apiClient;
    }


    public Api_Interface getApi(){
        return retrofit.create(Api_Interface.class);
    }

}
