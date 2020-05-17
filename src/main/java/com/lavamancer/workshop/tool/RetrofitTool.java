package com.lavamancer.workshop.tool;

import org.springframework.stereotype.Component;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.annotation.PostConstruct;

@Component
public class RetrofitTool {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    public RetrofitApi retrofitApi;


    @PostConstruct
    public void init() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();
        retrofitApi = retrofit.create(RetrofitApi.class);
    }


}
