package com.japb.service;

import com.japb.dto.PostDto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ConsumirApi {

    private final RestTemplate restTemplate;

    public ConsumirApi(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${variables.api.all}")
    private String allPostDto;

    public List<PostDto> getPost(){
        ResponseEntity<List<PostDto>> response = restTemplate.exchange(allPostDto, HttpMethod.GET,null,
                new ParameterizedTypeReference<List<PostDto>>() {});
        return response.getBody();
    }

    public PostDto get(Integer id){
        return restTemplate.getForEntity(allPostDto + id, PostDto.class).getBody();
    }

    public PostDto create(PostDto postDto){
        return restTemplate.postForObject("https://jsonplaceholder.typicode.com/posts",  postDto, PostDto.class);
    }

    public PostDto update(Integer id, PostDto postDto){
        HttpEntity<PostDto> httpEntity = new HttpEntity<>(postDto);
        ResponseEntity<PostDto> response = restTemplate.exchange("https://jsonplaceholder.typicode.com/posts" + id,
                HttpMethod.PUT, httpEntity, PostDto.class);

        return response.getBody();
    }

    public void delete(Integer id){
        restTemplate.delete("https://jsonplaceholder.typicode.com/posts/" + id);
    }
}
