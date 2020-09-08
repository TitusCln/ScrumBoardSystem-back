package com.sbs.userStories.models;

import com.sbs.contracts.dto.TaskDTO;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String description;
    @Column(precision = 1)
    private Double duration;
    @ManyToOne
    @JoinColumn(name = "userstory_id")
    private UserStory userStory;
    @Column
    private Boolean done;
    @Column(name = "order_position")
    private Integer order;
    @CreationTimestamp
    private LocalDateTime createdTimeStamp;
    @UpdateTimestamp
    private LocalDateTime updatedTimeStamp;

    public Task() {
    }

    public Task(TaskDTO task) {
        this.id = task.getId();
        this.description = task.getDescription();
        this.duration = task.getDuration();
        this.done = task.getDone();
        this.order = task.getOrder();
    }


    public Task(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public UserStory getUserStory() {
        return userStory;
    }

    public void setUserStory(UserStory userStory) {
        this.userStory = userStory;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public LocalDateTime getCreatedTimeStamp() {
        return createdTimeStamp;
    }

    public void setCreatedTimeStamp(LocalDateTime createdTimeStamp) {
        this.createdTimeStamp = createdTimeStamp;
    }

    public LocalDateTime getUpdatedTimeStamp() {
        return updatedTimeStamp;
    }

    public void setUpdatedTimeStamp(LocalDateTime updatedTimeStamp) {
        this.updatedTimeStamp = updatedTimeStamp;
    }

    public Task withUserStory(UserStory userStory) {
        this.userStory = userStory;
        return this;
    }

    /**
     * Transforms the Task Entity to the TaskDTO Object
     *
     * @return the DTO Task Object
     */
    public TaskDTO toDTO() {
        return new TaskDTO.Builder()
                .withId(this.id)
                .withDescription(this.description)
                .withDuration(this.duration)
                .withDone(this.done)
                .withOrder(this.order)
                .withCreatedTimeStamp(this.createdTimeStamp)
                .withUpdatedTimeStamp(this.updatedTimeStamp)
                .build();
    }

    /**
     * Sets the mock relationship between the the Task and the User Story
     *
     * @param userStoryId the User Story related id
     */
    public void setIsolatedUserStory(Long userStoryId) {
        UserStory userStory = new UserStory();
        userStory.setId(userStoryId);
        this.userStory = userStory;
    }
}
