
package com.myblog.myblog1.service.impl;
import com.myblog.myblog1.entity.Post;
import com.myblog.myblog1.exception.ResourceNotFoundException;
import com.myblog.myblog1.payload.PostDto;
import com.myblog.myblog1.repository.PostRepository;
import com.myblog.myblog1.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service // mention for this is service layer/ model layer all the database operation in service layer
public class PostServiceImpl implements PostService {

    private PostRepository postRepository; //  implement repository layer in class


    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;

    }


    @Override
    public PostDto createPost(PostDto postDto) { // implement form Dto Class

        Post post = mapToEntity(postDto);
        Post savedPost = postRepository.save(post); // save in dto
        PostDto dto = mapToDto(savedPost); // Convert to Entity to DTO
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


    @Override //       incomplete method from interface complete to class
    public List<PostDto> getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir) { // list of the data form database read the data
        Sort sort = (sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();// Ternary Operator for if else
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort); // pagination & sorting
        Page<Post> pagePost = postRepository.findAll(pageable); // pagination concept
        List<Post> posts = pagePost.getContent();

        List<PostDto> dtos = posts.stream().map(p -> mapToDto(p)).collect(Collectors.toList()); // stream API
        return dtos;
    }


    PostDto mapToDto(Post post) { // Entity object convert to Dto
        PostDto dto = new PostDto(); // Dto class Object
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setDescription(post.getDescription());
        dto.setContent(post.getContent()); // Corrected method name to setContent()re
        return dto;
    }


    Post mapToEntity(PostDto postDto) {
        Post post = new Post(); // Entity Object
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent()); // Corrected method name to setContent()
        return post;
    }
}
