package com.myblog.myblog1.controller;

import com.myblog.myblog1.payload.PostDto;
import com.myblog.myblog1.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/posts") // ues to  handel web  request
public class PostController {


    private PostService postService;// Interface  // Take the Data for PostDTO Class and pass to service layer / Model database operations

    public PostController(PostService postService) { // Constructor Based Injections
        this.postService = postService;
    }


    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) { //  request body can take JSON Object & put in DTO Class form custom response to back
        PostDto dto = postService.createPost(postDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }


    // http://localhost:8080/api/posts/particular?id=1
    @GetMapping("/particular")
    public ResponseEntity<PostDto> getPostById(@RequestParam long id) {
        PostDto dto = postService.getPostById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    //  http://localhost:8080/api/posts/all?pageNo=0&pageSize=5&sortBy=title&sortDir=desc
    // http://localhost:8080/api/posts/all
    @GetMapping("/all") // 2get mapping is not same bcz confuse which url to  call
    public List<PostDto> getAllPosts(                    //   Read the data from the Database
                                                         @RequestParam(name = "pageNo", required = false, defaultValue = "0") int pageNo, // pagination
                                                         @RequestParam(name = "pageSize", required = false, defaultValue = "3") int pageSize,// pagination
                                                         @RequestParam(name = "sortBy", required = false, defaultValue = "id") String sortBy,
                                                         @RequestParam(name = "sortDir", required = false, defaultValue = "id") String sortDir) { // sorting ascending or descending
        List<PostDto> postDtos = postService.getAllPosts(pageNo, pageSize,sortBy , sortDir);  //  get list  of  the post  from database
        return postDtos;
    }


}
