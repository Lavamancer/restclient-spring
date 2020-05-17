package com.lavamancer.workshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class PostService {

    @Autowired RestTemplateTool restTemplateTool;


    public List<Post> getPosts() {
        return restTemplateTool.requestList("/posts");
    }

    public Post getPost(Long id) {
        return restTemplateTool.requestItem("/posts", id, Post.class);
    }

}
