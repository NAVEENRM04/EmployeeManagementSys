package com.demo.feedback.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.demo.feedback.dto.request.FeedbackRequest;
import com.demo.feedback.dto.response.FeedbackResponse;
import com.demo.feedback.model.Feedback;
import com.demo.feedback.repository.FeedbackRepository;
import com.demo.feedback.service.FeedbackService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {
    private final FeedbackRepository feedbackRepository;

    @Override
    public Feedback savefeedback(FeedbackRequest request) {
        // if (feedbackRepository.findByUsernameAndEmail(request.getUsername(),request.getEmail()).isPresent()) {
        //     return false;
        // }

        var feedback = Feedback.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .feedback(request.getFeedback())
                .build();
        return feedbackRepository.save(feedback);
        // return true;
    }

    @Override
    public List<FeedbackResponse> getAllfeedbacksList() {
        List<Feedback> feedbacks = feedbackRepository.findAll();
        return feedbacks.stream()
                .map(feedback -> {
                    FeedbackResponse response = new FeedbackResponse();
                    response.setFid(feedback.getFid());
                    response.setUsername(feedback.getUsername());
                    response.setEmail(feedback.getEmail());
                    response.setFeedback(feedback.getFeedback());
                    return response;
                })
                .collect(Collectors.toList());
    }
}
