package com.sbs.contracts.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;

@JsonDeserialize(builder = TaskDTO.Builder.class)
public class TaskDTO {

    private Long id;
    private String description;
    private Double duration;
    private Boolean done;
    private Integer order;
    private LocalDateTime createdTimeStamp;
    private LocalDateTime updatedTimeStamp;

    public TaskDTO() {
    }

    public TaskDTO(Builder builder) {
        this.id = builder.id;
        this.description = builder.description;
        this.duration = builder.duration;
        this.done = builder.done;
        this.order = builder.order;
        this.createdTimeStamp = builder.createdTimeStamp;
        this.updatedTimeStamp = builder.updatedTimeStamp;
    }

    public TaskDTO(String description, Double duration, Boolean done, Integer order, LocalDateTime createdTimeStamp, LocalDateTime updatedTimeStamp) {
        this.description = description;
        this.duration = duration;
        this.done = done;
        this.order = order;
        this.createdTimeStamp = createdTimeStamp;
        this.updatedTimeStamp = updatedTimeStamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        description = description;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
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

    public static class Builder {
        private Long id;
        private String description;
        private Double duration;
        private Boolean done;
        private Integer order;
        private LocalDateTime createdTimeStamp;
        private LocalDateTime updatedTimeStamp;

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withDuration(Double duration) {
            this.duration = duration;
            return this;
        }

        public Builder withDone(Boolean done) {
            this.done = done;
            return this;
        }

        public Builder withOrder(Integer order) {
            this.order = order;
            return this;
        }

        public Builder withCreatedTimeStamp(LocalDateTime createdTimeStamp) {
            this.createdTimeStamp = createdTimeStamp;
            return this;
        }

        public Builder withUpdatedTimeStamp(LocalDateTime updatedTimeStamp) {
            this.updatedTimeStamp = updatedTimeStamp;
            return this;
        }

        public TaskDTO build() {
            return new TaskDTO(this);
        }
    }
}
