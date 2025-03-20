//package com.vr.controller;
//
//import com.vr.entity.ActivityFeedback;
//import com.vr.service.ActivityFeedbackService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/feedbacks")
//public class ActivityFeedbackController_copy {
//    @Autowired
//    private ActivityFeedbackService service;
//
//    // 新增反馈
//    @PostMapping
//    public ResponseEntity<ActivityFeedback> saveFeedback(@RequestBody ActivityFeedback feedback) {
//        ActivityFeedback savedFeedback = service.saveFeedback(feedback);
//        return new ResponseEntity<>(savedFeedback, HttpStatus.CREATED);
//    }
//
//    // 查询所有反馈
//    @GetMapping
//    public ResponseEntity<List<ActivityFeedback>> getAllFeedbacks() {
//        List<ActivityFeedback> feedbacks = service.getAllFeedbacks();
//        return new ResponseEntity<>(feedbacks, HttpStatus.OK);
//    }
//
//    // 根据 ID 查询反馈
//    @GetMapping("/{id}")
//    public ResponseEntity<ActivityFeedback> getFeedbackById(@PathVariable Integer id) {
//        Optional<ActivityFeedback> feedbackOptional = service.getFeedbackById(id);
//        return feedbackOptional.map(feedback -> new ResponseEntity<>(feedback, HttpStatus.OK))
//                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//
//    // 修改反馈
//    @PutMapping("/{id}")
//    public ResponseEntity<ActivityFeedback> updateFeedback(@PathVariable Integer id, @RequestBody ActivityFeedback feedback) {
//        Optional<ActivityFeedback> existingFeedbackOptional = service.getFeedbackById(id);
//        if (existingFeedbackOptional.isPresent()) {
//            ActivityFeedback existingFeedback = existingFeedbackOptional.get();
//            existingFeedback.setActivityId(feedback.getActivityId());
//            existingFeedback.setUserId(feedback.getUserId());
//            existingFeedback.setContent(feedback.getContent());
//            existingFeedback.setScore(feedback.getScore());
//            existingFeedback.setImagePaths(feedback.getImagePaths());
//            existingFeedback.setStatus(feedback.getStatus());
//            ActivityFeedback updatedFeedback = service.updateFeedback(existingFeedback);
//            return new ResponseEntity<>(updatedFeedback, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    // 删除反馈
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteFeedback(@PathVariable Integer id) {
//        service.deleteFeedback(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//}