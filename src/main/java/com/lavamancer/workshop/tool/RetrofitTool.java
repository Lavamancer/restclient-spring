package com.lavamancer.workshop.tool;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
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
                .client(createHttpClient())
                .baseUrl(BASE_URL)
                .build();
        retrofitApi = retrofit.create(RetrofitApi.class);
    }

    private OkHttpClient createHttpClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(loggingInterceptor);
        return builder.build();
    }


}
