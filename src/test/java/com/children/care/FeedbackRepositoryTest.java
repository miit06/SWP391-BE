package com.children.care;

import com.children.care.Application;
import com.children.care.entity.Feedback;
import com.children.care.repository.FeedbackRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
class FeedbackRepositoryTest {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Test
    void testSaveFeedback() {
        Feedback feedback = new Feedback();
        feedback.setCustomerId(1L);
        feedback.setServiceId(2L);
        feedback.setFeedbackDetail("Dịch vụ tốt!");
        feedback.setRating(5);

        Feedback savedFeedback = feedbackRepository.save(feedback);

        assertThat(savedFeedback).isNotNull();
        assertThat(savedFeedback.getId()).isNotNull();
    }

    @Test
    void testFindById() {
        Feedback feedback = new Feedback();
        feedback.setCustomerId(3L);
        feedback.setServiceId(4L);
        feedback.setFeedbackDetail("Tạm ổn.");
        feedback.setRating(3);
        Feedback savedFeedback = feedbackRepository.save(feedback);

        Optional<Feedback> foundFeedback = feedbackRepository.findById(savedFeedback.getId());

        assertThat(foundFeedback).isPresent();
    }
}
