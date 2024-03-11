
package com.myblog.myblog1.service.impl;
import com.myblog.myblog1.entity.Post;
import com.myblog.myblog1.exception.ResourceNotFoundException;
import com.myblog.myblog1.payload.PostDto;
import com.myblog.myblog1.repository.PostRepository;
import com.myblog.myblog1.service.PostService;
import org.springframework.stereotype.Service;


@Service // mention for this is service layer/ model layer all the database operation in service layer
public class PostServiceImpl implements PostService {

    private PostRepository postRepository; //  implement repository layer in class

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) { // implement form Dto Class
        Post post = new Post(); // Entity Object
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent()); // Corrected method name to setContent()

        Post savedPost = postRepository.save(post); // save in dto

        PostDto dto = new PostDto(); // Dto class Object
        dto.setTitle(savedPost.getTitle());
        dto.setDescription(savedPost.getDescription());
        dto.setContent(savedPost.getContent()); // Corrected method name to setContent()

        return dto;
    }


    @Override //                          this method handel the exceptions in this project java 8
    public PostDto getPostById(long id) {

        Post post = postRepository.findById(id).orElseThrow( // new Java 8
                () -> new ResourceNotFoundException("Data is not found with id: " + id) // Corrected exception class name
        );


        PostDto dto = new PostDto(); // Dto class Object
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setDescription(post.getDescription());
        dto.setContent(post.getContent()); // Corrected method name to setContent()

        return dto;
    }
}
