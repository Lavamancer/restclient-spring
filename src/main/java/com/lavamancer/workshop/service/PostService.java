package com.lavamancer.workshop.service;

import com.lavamancer.workshop.model.Post;
import com.lavamancer.workshop.tool.RestTemplateTool;
import com.lavamancer.workshop.tool.RetrofitTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@Transactional
@Service
public class PostService {

    @Autowired RestTemplateTool restTemplateTool;
    @Autowired RetrofitTool retrofitTool;


    public List<Post> getPosts(boolean retrofit) throws IOException {
        if (retrofit) {
            System.out.println("RETROFIT");
            return retrofitTool.retrofitApi.getPosts().execute().body();
        } else {
            System.out.println("REST TEMPLATE");
            return restTemplateTool.requestList("/posts");
        }
    }

    public Post getPost(boolean retrofit, Long id) throws IOException {
        if (retrofit) {
            System.out.println("RETROFIT");
            return retrofitTool.retrofitApi.getPost(id).execute().body();
        } else {
            System.out.println("REST TEMPLATE");
            return restTemplateTool.requestItem("/posts", id, Post.class);
        }
    }

}
