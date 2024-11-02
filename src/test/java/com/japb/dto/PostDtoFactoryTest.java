package com.japb.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class PostDtoFactoryTest {

    @Test
    void testCreatePostDto() {
        PostDto postDto = PostDtoFactory.createPostDto(1, "Title", "Body", 123);

        assertThat(postDto.getId()).isEqualTo(1);
        assertThat(postDto.getTitle()).isEqualTo("Title");
        assertThat(postDto.getBody()).isEqualTo("Body");
        assertThat(postDto.getUserId()).isEqualTo(123);
    }

    @Test
    void testCreateDefaultPostDto() {
        PostDto postDto = PostDtoFactory.createDefaultPostDto("Title", "Body", 123);

        assertThat(postDto.getId()).isNull(); // ID debe ser nulo
        assertThat(postDto.getTitle()).isEqualTo("Title");
        assertThat(postDto.getBody()).isEqualTo("Body");
        assertThat(postDto.getUserId()).isEqualTo(123);
    }

}