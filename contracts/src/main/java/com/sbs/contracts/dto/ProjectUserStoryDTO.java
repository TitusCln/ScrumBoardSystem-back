package com.sbs.contracts.dto;

public class ProjectUserStoryDTO {

    private ProjectDTO projectDTO;
    private Long userStoryId;

    public ProjectUserStoryDTO() {
    }

    public ProjectUserStoryDTO(Builder builder) {
        this.projectDTO = builder.projectDTO;
        this.userStoryId = builder.userStoryId;
    }

    public ProjectDTO getProjectDTO() {
        return projectDTO;
    }

    public void setProjectDTO(ProjectDTO projectDTO) {
        this.projectDTO = projectDTO;
    }

    public Long getUserStoryId() {
        return userStoryId;
    }

    public void setUserStoryId(Long userStoryId) {
        this.userStoryId = userStoryId;
    }

    public static class Builder {

        private ProjectDTO projectDTO;
        private Long userStoryId;

        public Builder withProject(ProjectDTO project) {
            this.projectDTO = project;
            return this;
        }

        public Builder withUserStoryId(Long userStoryId) {
            this.userStoryId = userStoryId;
            return this;
        }

        public ProjectUserStoryDTO build() {
            return new ProjectUserStoryDTO(this);
        }

    }
}
