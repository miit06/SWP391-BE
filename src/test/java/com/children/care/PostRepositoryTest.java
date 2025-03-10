package com.children.care;

import com.children.care.entity.Post;
import com.children.care.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // Sử dụng database thực tế
class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Test
    void testSavePost() {
        // Given
        Post post = new Post();
        post.setThumbnail("thumbnail.jpg");
        post.setTitle("Bài viết mới");
        post.setBriefInformation("Thông tin ngắn gọn");
        post.setDescription("Mô tả chi tiết");
        post.setAuthor("Tác giả A");
        post.setFlag(1);
        post.setStatus(1);
        post.setCategoryId(2);

        // When
        Post savedPost = postRepository.save(post);

        // Then
        assertThat(savedPost).isNotNull();
        assertThat(savedPost.getId()).isNotNull();
        assertThat(savedPost.getTitle()).isEqualTo("Bài viết mới");
    }

    @Test
    void testFindById() {
        // Given
        Post post = new Post();
        post.setThumbnail("test.jpg");
        post.setTitle("Test Post");
        post.setBriefInformation("Brief Info");
        post.setDescription("Description");
        post.setAuthor("Author B");
        post.setFlag(0);
        post.setStatus(1);
        post.setCategoryId(3);
        Post savedPost = postRepository.save(post);

        // When
        Optional<Post> foundPost = postRepository.findById(savedPost.getId());

        // Then
        assertThat(foundPost).isPresent();
        assertThat(foundPost.get().getTitle()).isEqualTo("Test Post");
    }

    @Test
    void testDeletePost() {
        // Given
        Post post = new Post();
        post.setThumbnail("delete.jpg");
        post.setTitle("Delete Me");
        post.setBriefInformation("To be deleted");
        post.setDescription("Deleting this post");
        post.setAuthor("Author C");
        post.setFlag(1);
        post.setStatus(1);
        post.setCategoryId(4);
        Post savedPost = postRepository.save(post);
        Long postId = savedPost.getId();

        // When
        postRepository.deleteById(postId);
        Optional<Post> deletedPost = postRepository.findById(postId);

        // Then
        assertThat(deletedPost).isEmpty();
    }
}
