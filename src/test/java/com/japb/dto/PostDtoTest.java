package com.japb.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PostDtoTest {

    @Test
    public void testPostDtoConstructorAndGetters() {
        PostDto postDto = new PostDto(1, "Title", "Body", 123);

        assertThat(postDto.getId()).isEqualTo(1);
        assertThat(postDto.getTitle()).isEqualTo("Title");
        assertThat(postDto.getBody()).isEqualTo("Body");
        assertThat(postDto.getUserId()).isEqualTo(123);
    }

    @Test
    public void testPostDtoSetters() {
        PostDto postDto = new PostDto();
        postDto.setId(2);
        postDto.setTitle("New Title");
        postDto.setBody("New Body");
        postDto.setUserId(456);

        assertThat(postDto.getId()).isEqualTo(2);
        assertThat(postDto.getTitle()).isEqualTo("New Title");
        assertThat(postDto.getBody()).isEqualTo("New Body");
        assertThat(postDto.getUserId()).isEqualTo(456);
    }
}