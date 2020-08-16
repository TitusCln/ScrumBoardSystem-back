package com.sbs.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = Task.Builder.class)
public class Task {

    private Long id;
    private String description;
    private Double duration;

    public Task() {
    }

    public Task(Builder builder) {
        this.id = builder.id;
        this.description = builder.description;
        this.duration = builder.duration;
    }


    public Task(String description, Double duration, UserStory userStory) {
        this.description = description;
        this.duration = duration;
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

    public static class Builder {
        private Long id;
        private String description;
        private Double duration;

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

        public Task build() {
            return new Task(this);
        }
    }
}
