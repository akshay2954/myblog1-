package com.myblog.myblog1.service;

import com.myblog.myblog1.payload.PostDto;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto);  // incomplete method is complete to class

    PostDto getPostById(long id); //


    List<PostDto> getAllPosts(int pageNo, int pageSize); // get the List Of the data fromm the database
    //                           this incomplete method is complete to the PostServiceImpl Class
}
