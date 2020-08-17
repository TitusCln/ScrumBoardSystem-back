package com.sbs.contracts.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = TaskDTO.Builder.class)
public class TaskDTO {

    private Long id;
    private String description;
    private Double duration;

    public TaskDTO() {
    }

    public TaskDTO(Builder builder) {
        this.id = builder.id;
        this.description = builder.description;
        this.duration = builder.duration;
    }


    public TaskDTO(String description, Double duration, UserStoryDTO userStoryDTO) {
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

        public TaskDTO build() {
            return new TaskDTO(this);
        }
    }
}
