package com.children.care.service;

import com.children.care.entity.Feedback;
import com.children.care.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;

    public List<Feedback> getAllFeedbacks() { return feedbackRepository.findAll(); }
    public Feedback getFeedbackById(Long id) { return feedbackRepository.findById(id).orElse(null); }
    public Feedback createFeedback(Feedback feedback) { return feedbackRepository.save(feedback); }
    public Feedback updateFeedback(Long id, Feedback updatedFeedback) {
        return feedbackRepository.findById(id).map(feedback -> {
            feedback.setCustomerId(updatedFeedback.getCustomerId());
            feedback.setServiceId(updatedFeedback.getServiceId());
            feedback.setFeedbackDetail(updatedFeedback.getFeedbackDetail());
            feedback.setRating(updatedFeedback.getRating());
            return feedbackRepository.save(feedback);
        }).orElse(null);
    }
    public boolean deleteFeedback(Long id) {
        if (feedbackRepository.existsById(id)) {
            feedbackRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
