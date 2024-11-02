package com.japb.service;

import com.japb.dto.PostDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;


class ConsumirApiTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private ConsumirApi consumirApi;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        consumirApi.setAllPostDto("https://jsonplaceholder.typicode.com/posts/"); // Asignar la URL para las pruebas
    }

    @Test
    void testGetPost() {
        // Arrange
        List<PostDto> expectedPosts = List.of(new PostDto(1, "Title 1", "Body 1", 123));
        ResponseEntity<List<PostDto>> responseEntity = ResponseEntity.ok(expectedPosts);
        when(restTemplate.exchange(anyString(), eq(HttpMethod.GET), isNull(),
                any(ParameterizedTypeReference.class))).thenReturn(responseEntity);

        // Act
        List<PostDto> actualPosts = consumirApi.getPost();

        // Assert
        assertEquals(expectedPosts, actualPosts);
    }

    @Test
    void testGet() {
        // Arrange
        PostDto expectedPost = new PostDto(1, "Title 1", "Body 1", 123);
        ResponseEntity<PostDto> responseEntity = ResponseEntity.ok(expectedPost);
        when(restTemplate.getForEntity(anyString(), eq(PostDto.class))).thenReturn(responseEntity);

        // Act
        PostDto actualPost = consumirApi.get(1);

        // Assert
        assertEquals(expectedPost, actualPost);
    }

    @Test
    void testCreate() {
        // Arrange
        PostDto postDto = new PostDto(1, "Title 1", "Body 1", 123);
        when(restTemplate.postForObject(anyString(), any(), eq(PostDto.class))).thenReturn(postDto);

        // Act
        PostDto actualPost = consumirApi.create("Title 1", "Body 1", 123);

        // Assert
        assertEquals(postDto, actualPost);
    }

    @Test
    void testUpdate() {
        // Arrange
        PostDto postDto = new PostDto(1, "Updated Title", "Updated Body", 123);
        ResponseEntity<PostDto> responseEntity = ResponseEntity.ok(postDto);
        when(restTemplate.exchange(anyString(), eq(HttpMethod.PUT), any(HttpEntity.class), eq(PostDto.class)))
                .thenReturn(responseEntity);

        // Act
        PostDto actualPost = consumirApi.update(1, postDto);

        // Assert
        assertEquals(postDto, actualPost);
    }

    @Test
    void testDelete() {
        // Arrange
        int postId = 1;

        // Act
        consumirApi.delete(postId);

        // Assert
        verify(restTemplate, times(1)).delete("https://jsonplaceholder.typicode.com/posts/" + postId);
    }
}