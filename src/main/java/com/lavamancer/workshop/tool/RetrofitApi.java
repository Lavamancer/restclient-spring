package com.lavamancer.workshop.tool;

import com.lavamancer.workshop.model.Post;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface RetrofitApi {

    @GET("posts")
    Call<List<Post>> getPosts();

    @GET("posts/{postId}")
    Call<Post> getPost(@Path("postId") Long postId);

}
