package com.japb.controller;

import static org.mockito.Mockito.*;

import com.japb.dto.PostDto;
import com.japb.service.ConsumirApi;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class PostControllerTest {

    @Mock
    private ConsumirApi consumirApi;

    @InjectMocks
    private PostController postController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetPost() {
        // Arrange
        List<PostDto> posts = List.of(new PostDto(1, "Title 1", "Body 1", 123));
        when(consumirApi.getPost()).thenReturn(posts);

        // Act
        ResponseEntity<List<PostDto>> response = postController.getPost();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(posts, response.getBody());
    }

    @Test
    void testGetPostById_Success() {
        // Arrange
        PostDto post = new PostDto(1, "Title 1", "Body 1", 123);
        when(consumirApi.get(1)).thenReturn(post);

        // Act
        ResponseEntity<PostDto> response = postController.getPostById(1);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(post, response.getBody());
    }

    @Test
    void testGetPostById_NotFound() {
        // Arrange
        when(consumirApi.get(1)).thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND));

        // Act & Assert
        assertThrows(PostNotFoundException.class, () -> postController.getPostById(1));
    }

    @Test
    void testSave() {
        // Arrange
        PostDto postDto = new PostDto(1, "Title 1", "Body 1", 123);
        when(consumirApi.create("Title 1", "Body 1", 1)).thenReturn(postDto);

        // Act
        ResponseEntity<PostDto> response = postController.save(postDto);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(postDto, response.getBody());
    }

    @Test
    void testUpdate() {
        // Arrange
        PostDto postDto = new PostDto(1, "Updated Title", "Updated Body", 123);
        when(consumirApi.update(1, postDto)).thenReturn(postDto);

        // Act
        ResponseEntity<PostDto> response = postController.update(1, postDto);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(postDto, response.getBody());
    }

    @Test
    void testDelete() {
        // Arrange
        int postId = 1;

        // Act
        ResponseEntity<?> response = postController.delete(postId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Post delete", response.getBody());
        verify(consumirApi, times(1)).delete(postId);
    }
}