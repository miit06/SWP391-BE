package com.children.care;



import com.children.care.controller.FeedbackController;
import com.children.care.entity.Feedback;
import com.children.care.service.FeedbackService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FeedbackControllerTest {

    @Mock
    private FeedbackService feedbackService;

    @InjectMocks
    private FeedbackController feedbackController;

    private Feedback feedback1;
    private Feedback feedback2;

    @BeforeEach
    void setUp() {
        feedback1 = new Feedback();
        feedback1.setId(1L);
        feedback1.setCustomerId(101L);
        feedback1.setServiceId(201L);
        feedback1.setFeedbackDetail("Great service!");
        feedback1.setRating(5);

        feedback2 = new Feedback();
        feedback2.setId(2L);
        feedback2.setCustomerId(102L);
        feedback2.setServiceId(202L);
        feedback2.setFeedbackDetail("Average experience.");
        feedback2.setRating(3);
    }

    @Test
    void testGetAllFeedbacks() {
        List<Feedback> feedbacks = Arrays.asList(feedback1, feedback2);
        when(feedbackService.getAllFeedbacks()).thenReturn(feedbacks);

        ResponseEntity<List<Feedback>> response = feedbackController.getAllFeedbacks();

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(2, response.getBody().size());
    }

    @Test
    void testGetFeedbackById_Found() {
        when(feedbackService.getFeedbackById(1L)).thenReturn(feedback1);
        ResponseEntity<Feedback> response = feedbackController.getFeedbackById(1L);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(feedback1, response.getBody());
    }

    @Test
    void testGetFeedbackById_NotFound() {
        when(feedbackService.getFeedbackById(3L)).thenReturn(null);
        ResponseEntity<Feedback> response = feedbackController.getFeedbackById(3L);

        assertEquals(404, response.getStatusCodeValue());
    }

    @Test
    void testCreateFeedback() {
        when(feedbackService.createFeedback(any(Feedback.class))).thenReturn(feedback1);
        ResponseEntity<Feedback> response = feedbackController.createFeedback(feedback1);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(feedback1, response.getBody());
    }

    @Test
    void testUpdateFeedback_Found() {
        when(feedbackService.updateFeedback(eq(1L), any(Feedback.class))).thenReturn(feedback1);
        ResponseEntity<Feedback> response = feedbackController.updateFeedback(1L, feedback1);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(feedback1, response.getBody());
    }

    @Test
    void testUpdateFeedback_NotFound() {
        when(feedbackService.updateFeedback(eq(3L), any(Feedback.class))).thenReturn(null);
        ResponseEntity<Feedback> response = feedbackController.updateFeedback(3L, feedback1);

        assertEquals(404, response.getStatusCodeValue());
    }
}