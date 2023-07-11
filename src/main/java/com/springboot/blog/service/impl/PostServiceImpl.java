package com.springboot.blog.service.impl;

import com.springboot.blog.Payload.PostDto;
import com.springboot.blog.entity.Post;
import com.springboot.blog.exception.ResourceNotFoundException;
import com.springboot.blog.repository.PostRepository;
import com.springboot.blog.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

        //constructor based dependency injection
    //if we have sinngle contructor then @Autowired is not required

    private PostRepository postRepository ;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {

        //convert postResponse to entity

        Post post = mapToEntity(postDto) ;

         Post newPost = postRepository.save(post) ;

         //convert entity into DTO

        PostDto postResponse = mapToDto(newPost) ;
        return postResponse;
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts = postRepository.findAll() ;

        return posts.stream().map(post -> mapToDto(post)).
                collect(Collectors.toList()) ;
    }

    @Override
    public PostDto getPostById(long id) {

        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("post" , "postId" , id)) ;
        return mapToDto(post);
    }

    @Override
    public PostDto updatePost(PostDto postDto, long id) {
        //get Post from database

        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("post" , "id" , id)) ;

        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());

        Post updatedPost =  postRepository.save(post) ;

        return mapToDto(updatedPost);
    }

    @Override
    public void deletePost(long id) {

        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("post" , "id" , id)) ;

        postRepository.delete(post);

    }


    //Convert entity into DTO
    private PostDto mapToDto(Post post){

        PostDto postDto =  new PostDto() ;
        postDto.setId(post.getId());
        postDto.setTitle(post.getContent());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());

        return  postDto ;

    }

    //map to Entity
    private Post mapToEntity(PostDto  postDto) {
        Post post = new Post() ;
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        post.setTitle(postDto.getTitle());
        return post ;
    }
}
