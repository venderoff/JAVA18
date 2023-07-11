package com.springboot.blog.controller;

import com.springboot.blog.Payload.Message;
import com.springboot.blog.Payload.PostDto;
import com.springboot.blog.exception.ResourceNotFoundException;
import com.springboot.blog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    //service interface for loose coupling
    PostService postService ;

    public PostController(PostService postService) {
        this.postService = postService;
    }
@PostMapping
//    public ResponseEntity<PostDto> createpost ( @RequestBody PostDto postDto) {
    public ResponseEntity<Object> createpost ( @RequestBody PostDto postDto) {

//        postService.createPost(postDto) ;
try {
    ResponseEntity<PostDto> dt = new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
return new ResponseEntity<>(dt.getBody(),HttpStatus.CREATED) ;
}
 catch (Exception e) {

     Message message = new Message() ;
//     message.setMessage(e.getMessage());
     message.setMessage(e.getMessage());


     return  ResponseEntity.ok(message) ;
 }


//        return  new ResponseEntity<>(postService.createPost(postDto) , HttpStatus.CREATED) ;

    }

    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPost() {
//    public ReponseEntity<List<PostDto>> getAllPost() {
//        return postService.getAllPosts() ;
        return ResponseEntity.ok(postService.getAllPosts()) ;
    }
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable("id") long id) {

        return ResponseEntity.ok(postService.getPostById(id)) ;
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@PathVariable("id") long id , @RequestBody PostDto postDto) {


        return ResponseEntity.ok(postService.updatePost(postDto,id)) ;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Message> deletePost(@PathVariable("id") long id) {

        postService.deletePost(id) ;
        Message msg = new Message() ;
        msg.setMessage("Deleted Successfully");
        return ResponseEntity.ok(msg) ;

    }
}
