package com.myblog.myblog1.controller;
import com.myblog.myblog1.payload.PostDto;
import com.myblog.myblog1.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/posts") // ues to  handel web  request
public class PostController {

    private PostService postService ;// Interface  // Take the Data for PostDTO Class and pass to service layer / Model database operations

    public PostController(PostService postService) { // Constructor Based Injections
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){ //  request body can take JSON Object & put in DTO Class form custom response to back
       PostDto dto= postService.createPost(postDto);
       return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
}
