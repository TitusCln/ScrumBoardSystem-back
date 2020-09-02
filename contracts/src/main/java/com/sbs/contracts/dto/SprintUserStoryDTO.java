package com.sbs.contracts.dto;

public class SprintUserStoryDTO {

    private SprintDTO sprintDTO;
    private Long userStoryId;

    public SprintUserStoryDTO() {
    }

    public SprintUserStoryDTO(Builder builder) {
        this.sprintDTO = builder.sprintDTO;
        this.userStoryId = builder.userStoryId;
    }

    public SprintDTO getSprntDTO() {
        return sprintDTO;
    }

    public void setSprintDTO(SprintDTO sprintDTO) {
        this.sprintDTO = sprintDTO;
    }

    public Long getUserStoryId() {
        return userStoryId;
    }

    public void setUserStoryId(Long userStoryId) {
        this.userStoryId = userStoryId;
    }

    public static class Builder {

        private SprintDTO sprintDTO;
        private Long userStoryId;

        public Builder withSprint(SprintDTO sprint) {
            this.sprintDTO = sprint;
            return this;
        }

        public Builder withUserStoryId(Long userStoryId) {
            this.userStoryId = userStoryId;
            return this;
        }

        public SprintUserStoryDTO build() {
            return new SprintUserStoryDTO(this);
        }

    }
}
