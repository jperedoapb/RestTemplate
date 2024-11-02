package com.japb.dto;

public class PostDtoFactory {

    public static PostDto createPostDto(Integer id, String title, String body, Integer userId) {
        PostDto postDto = new PostDto();
        postDto.setId(id);
        postDto.setTitle(title);
        postDto.setBody(body);
        postDto.setUserId(userId);
        return postDto;
    }

    public static PostDto createDefaultPostDto(String title, String body, Integer userId) {
        return createPostDto(null, title, body, userId); // ID se establece como null para indicar que es nuevo
    }
}
