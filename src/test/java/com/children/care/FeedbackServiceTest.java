package com.children.care;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.children.care.entity.Feedback;
import com.children.care.repository.FeedbackRepository;
import com.children.care.service.FeedbackService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class FeedbackServiceTest {

    @Mock
    private FeedbackRepository feedbackRepository;

    @InjectMocks
    private FeedbackService feedbackService;

    private Feedback feedback;

    @BeforeEach
    void setUp() {
        feedback = new Feedback();
        feedback.setId(1L);
        feedback.setCustomerId(2L);
        feedback.setServiceId(3L);
        feedback.setFeedbackDetail("Great service!");
        feedback.setRating(5);
    }

    @Test
    void testGetAllFeedbacks() {
        when(feedbackRepository.findAll()).thenReturn(Arrays.asList(feedback));
        List<Feedback> feedbacks = feedbackService.getAllFeedbacks();
        assertEquals(1, feedbacks.size());
        verify(feedbackRepository, times(1)).findAll();
    }

    @Test
    void testGetFeedbackById() {
        when(feedbackRepository.findById(1L)).thenReturn(Optional.of(feedback));
        Feedback foundFeedback = feedbackService.getFeedbackById(1L);
        assertNotNull(foundFeedback);
        assertEquals(1L, foundFeedback.getId());
        verify(feedbackRepository, times(1)).findById(1L);
    }

    @Test
    void testCreateFeedback() {
        when(feedbackRepository.save(any(Feedback.class))).thenReturn(feedback);
        Feedback createdFeedback = feedbackService.createFeedback(feedback);
        assertNotNull(createdFeedback);
        assertEquals("Great service!", createdFeedback.getFeedbackDetail());
        verify(feedbackRepository, times(1)).save(any(Feedback.class));
    }

    @Test
    void testUpdateFeedback() {
        Feedback updatedFeedback = new Feedback();
        updatedFeedback.setCustomerId(2L);
        updatedFeedback.setServiceId(3L);
        updatedFeedback.setFeedbackDetail("Updated feedback");
        updatedFeedback.setRating(4);

        when(feedbackRepository.findById(1L)).thenReturn(Optional.of(feedback));
        when(feedbackRepository.save(any(Feedback.class))).thenReturn(updatedFeedback);

        Feedback result = feedbackService.updateFeedback(1L, updatedFeedback);
        assertNotNull(result);
        assertEquals("Updated feedback", result.getFeedbackDetail());
        assertEquals(4, result.getRating());
        verify(feedbackRepository, times(1)).findById(1L);
        verify(feedbackRepository, times(1)).save(any(Feedback.class));
    }

    @Test
    void testDeleteFeedback() {
        when(feedbackRepository.existsById(1L)).thenReturn(true);
        doNothing().when(feedbackRepository).deleteById(1L);
        boolean result = feedbackService.deleteFeedback(1L);
        assertTrue(result);
        verify(feedbackRepository, times(1)).existsById(1L);
        verify(feedbackRepository, times(1)).deleteById(1L);
    }
}
