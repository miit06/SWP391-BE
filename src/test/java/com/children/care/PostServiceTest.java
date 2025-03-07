package com.children.care;

import com.children.care.entity.Post;
import com.children.care.repository.PostRepository;
import com.children.care.service.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostService postService;

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
        when(postRepository.findAll()).thenReturn(posts);

        List<Post> result = postService.getAllPosts();
        assertEquals(1, result.size());
    }

    @Test
    void getPostById_ShouldReturnPost_WhenExists() {
        when(postRepository.findById(1L)).thenReturn(Optional.of(post));

        Post result = postService.getPostById(1L);
        assertNotNull(result);
        assertEquals("Test Post", result.getTitle());
    }

    @Test
    void createPost_ShouldReturnSavedPost() {
        when(postRepository.save(post)).thenReturn(post);

        Post result = postService.createPost(post);
        assertNotNull(result);
        assertEquals("Test Post", result.getTitle());
    }

    @Test
    void updatePost_ShouldReturnUpdatedPost_WhenExists() {
        Post updatedPost = new Post();
        updatedPost.setTitle("Updated Title");
        when(postRepository.findById(1L)).thenReturn(Optional.of(post));
        when(postRepository.save(any(Post.class))).thenReturn(updatedPost);

        Post result = postService.updatePost(1L, updatedPost);
        assertNotNull(result);
        assertEquals("Updated Title", result.getTitle());
    }

    @Test
    void deletePost_ShouldReturnTrue_WhenExists() {
        when(postRepository.existsById(1L)).thenReturn(true);
        doNothing().when(postRepository).deleteById(1L);

        boolean result = postService.deletePost(1L);
        assertTrue(result);
    }

    @Test
    void deletePost_ShouldReturnFalse_WhenNotExists() {
        when(postRepository.existsById(1L)).thenReturn(false);

        boolean result = postService.deletePost(1L);
        assertFalse(result);
    }
}
