package com.vr.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "activity_feedback")
@Data
public class ActivityFeedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer activityId;
    private Integer userId;
    private String content;
    private Integer score;
    private String imagePaths;
    @Column(updatable = false)
    private Date createdAt;
    private Date updatedAt;
    private Integer status;
}
