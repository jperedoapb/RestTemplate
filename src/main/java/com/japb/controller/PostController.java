package com.japb.controller;

import com.japb.dto.PostDto;
import com.japb.service.ConsumirApi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;


@RestController
@RequestMapping("/api")
public class PostController implements PostControllerSpec{

    private static final Logger log = LoggerFactory.getLogger(PostController.class);
    private ConsumirApi consumirApi;
    public PostController(ConsumirApi consumirApi) {
        this.consumirApi = consumirApi;
    }

    @Override
    public ResponseEntity<List<PostDto>> getPost(){
        return new ResponseEntity<>(consumirApi.getPost(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PostDto> getPostById(@PathVariable int id){
        log.info("Request to get post with ID: {}", id);
        try {
            PostDto post = consumirApi.get(id);
            log.info("Post retrieved successfully: {}", post);
            return new ResponseEntity<>(post, HttpStatus.OK);
        } catch (HttpClientErrorException ex) {
            log.error("Error retrieving post with ID {}: {}", id, ex.getMessage());
            throw new PostNotFoundException("Post not found with ID: " + id);
        }



    }

    @Override
    public ResponseEntity<PostDto> save(@RequestBody PostDto postDto){
        // Extraer los valores del objeto postDto
        String title = postDto.getTitle();
        String body = postDto.getBody();
        Integer id = postDto.getId();
        return new ResponseEntity<>(consumirApi.create(title,body, id), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<PostDto> update(@PathVariable int id, @RequestBody PostDto post){
        return new ResponseEntity<>(consumirApi.update(id, post), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> delete(@PathVariable int id){
        consumirApi.delete(id);
        return new ResponseEntity<>("Post delete", HttpStatus.OK);
    }

}
