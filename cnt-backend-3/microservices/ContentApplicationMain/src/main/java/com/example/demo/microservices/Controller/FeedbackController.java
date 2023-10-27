package com.example.demo.microservices.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.microservices.Model.Feedback;
import com.example.demo.microservices.ServiceImpl.FeedbackService;
import com.example.demo.microservices.dto.request.FeedbackRequest;

import lombok.RequiredArgsConstructor;

@CrossOrigin
@RestController
@RequestMapping("/api/feedback")
@RequiredArgsConstructor
public class FeedbackController {
    private final FeedbackService feedbackService;

    @PostMapping("/addfeedback")

    public ResponseEntity<Feedback> saveFeedback(@RequestBody FeedbackRequest request) {
        return feedbackService.savefeedback(request);
    }

    @GetMapping("/getallfeedbacks")
    public List<Feedback> getFeedbacks() {
        return feedbackService.getAllfeedbacksList();
    }
}
