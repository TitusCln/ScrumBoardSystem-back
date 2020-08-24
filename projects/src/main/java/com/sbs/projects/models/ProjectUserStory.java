package com.sbs.projects.models;

import com.sbs.contracts.dto.ProjectUserStoryDTO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table
public class ProjectUserStory {

    @Id
    private Long userStoryId;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public ProjectUserStory() {
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Long getUserStoryId() {
        return userStoryId;
    }

    public void setUserStoryId(Long userStoryId) {
        this.userStoryId = userStoryId;
    }

    public void setIsolatedProjectId(Long projectId) {
        Project project = new Project();
        project.setId(projectId);
        this.project = project;
    }

    public ProjectUserStoryDTO toDTO() {
        return new ProjectUserStoryDTO.Builder()
                .withProject(this.project.toDTO())
                .withUserStoryId(this.userStoryId)
                .build();
    }
}
