package com.myblog.myblog1.service;

import com.myblog.myblog1.payload.PostDto;

public interface PostService {

    PostDto createPost(PostDto postDto);  // incomplete method is complete to class

    PostDto getPostById(long id);
}
