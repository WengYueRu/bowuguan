//package com.vr.service;
//
//import com.vr.entity.ActivityFeedback;
//import com.vr.repository.ActivityFeedbackRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class ActivityFeedbackService {
//    @Autowired
//    private ActivityFeedbackRepository repository;
//
//    // 新增反馈
//    public ActivityFeedback saveFeedback(ActivityFeedback feedback) {
//        return repository.save(feedback);
//    }
//
//    // 查询所有反馈
//    public List<ActivityFeedback> getAllFeedbacks() {
//        return repository.findAll();
//    }
//
//    // 根据 ID 查询反馈
//    public Optional<ActivityFeedback> getFeedbackById(Integer id) {
//        return repository.findById(id);
//    }
//
//    // 修改反馈
//    public ActivityFeedback updateFeedback(ActivityFeedback feedback) {
//        return repository.save(feedback);
//    }
//
//    // 删除反馈
//    public void deleteFeedback(Integer id) {
//        repository.deleteById(id);
//    }
//}
