package com.sbs.projects.models;

import com.sbs.contracts.dto.ProjectSprintDTO;

import javax.persistence.*;

@Entity
@Table
public class ProjectSprint {

    @Id
    private Long sprintId;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public ProjectSprint() {
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Long getSprintId() {
        return sprintId;
    }

    public void setSprintId(Long sprintId) {
        this.sprintId = sprintId;
    }

    public void setIsolatedProjectId(Long projectId) {
        Project project = new Project();
        project.setId(projectId);
        this.project = project;
    }

    public ProjectSprintDTO toDTO() {
        return new ProjectSprintDTO.Builder()
                .withProject(this.project.toDTO())
                .withSprintId(this.sprintId)
                .build();
    }
}
