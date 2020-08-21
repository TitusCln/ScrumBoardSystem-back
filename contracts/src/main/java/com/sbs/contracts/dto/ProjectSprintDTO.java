package com.sbs.contracts.dto;

public class ProjectSprintDTO {

    private ProjectDTO projectDTO;
    private Long sprintId;

    public ProjectSprintDTO() {
    }

    public ProjectSprintDTO(Builder builder) {
        this.projectDTO = builder.projectDTO;
        this.sprintId = builder.sprintId;
    }

    public ProjectDTO getProjectDTO() {
        return projectDTO;
    }

    public void setProjectDTO(ProjectDTO projectDTO) {
        this.projectDTO = projectDTO;
    }

    public Long getSprintId() {
        return sprintId;
    }

    public void setSprintId(Long sprintId) {
        this.sprintId = sprintId;
    }

    public static class Builder {

        private ProjectDTO projectDTO;
        private Long sprintId;

        public Builder withProject(ProjectDTO project) {
            this.projectDTO = project;
            return this;
        }

        public Builder withSprintId(Long sprintId) {
            this.sprintId = sprintId;
            return this;
        }

        public ProjectSprintDTO build() {
            return new ProjectSprintDTO(this);
        }

    }
}
