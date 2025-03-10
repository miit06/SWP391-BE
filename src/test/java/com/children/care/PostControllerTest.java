package com.children.care;

import com.children.care.controller.PostController;
import com.children.care.entity.Post;
import com.children.care.service.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PostControllerTest {

    @Mock
    private PostService postService;

    @InjectMocks
    private PostController postController;

    private Post post;

    @BeforeEach
    void setUp() {
        post = new Post();
        post.setId(1L);
        post.setTitle("Test Post");
    }

    @Test
    void getAllPosts_ShouldReturnPostList() {
        List<Post> posts = Arrays.asList(post);
        when(postService.getAllPosts()).thenReturn(posts);

        ResponseEntity<List<Post>> response = postController.getAllPosts();
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().size());
    }

    @Test
    void getPostById_ShouldReturnPost_WhenExists() {
        when(postService.getPostById(1L)).thenReturn(post);

        ResponseEntity<Post> response = postController.getPostById(1L);
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals("Test Post", response.getBody().getTitle());
    }

    @Test
    void getPostById_ShouldReturnNotFound_WhenNotExists() {
        when(postService.getPostById(1L)).thenReturn(null);

        ResponseEntity<Post> response = postController.getPostById(1L);
        assertEquals(404, response.getStatusCodeValue());
    }

    @Test
    void createPost_ShouldReturnCreatedPost() {
        when(postService.createPost(post)).thenReturn(post);

        ResponseEntity<Post> response = postController.createPost(post);
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals("Test Post", response.getBody().getTitle());
    }

    @Test
    void updatePost_ShouldReturnUpdatedPost_WhenExists() {
        Post updatedPost = new Post();
        updatedPost.setTitle("Updated Title");
        when(postService.updatePost(1L, updatedPost)).thenReturn(updatedPost);

        ResponseEntity<Post> response = postController.updatePost(1L, updatedPost);
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals("Updated Title", response.getBody().getTitle());
    }

    @Test
    void updatePost_ShouldReturnNotFound_WhenNotExists() {
        Post updatedPost = new Post();
        updatedPost.setTitle("Updated Title");
        when(postService.updatePost(1L, updatedPost)).thenReturn(null);

        ResponseEntity<Post> response = postController.updatePost(1L, updatedPost);
        assertEquals(404, response.getStatusCodeValue());
    }

    @Test
    void deletePost_ShouldReturnOk_WhenExists() {
        when(postService.deletePost(1L)).thenReturn(true);

        ResponseEntity<Void> response = postController.deletePost(1L);
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void deletePost_ShouldReturnNotFound_WhenNotExists() {
        when(postService.deletePost(1L)).thenReturn(false);

        ResponseEntity<Void> response = postController.deletePost(1L);
        assertEquals(404, response.getStatusCodeValue());
    }
}
