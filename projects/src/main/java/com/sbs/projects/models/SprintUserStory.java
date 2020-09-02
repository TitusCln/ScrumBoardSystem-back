package com.sbs.projects.models;

import com.sbs.contracts.dto.SprintUserStoryDTO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;


@Entity
@Table
public class SprintUserStory {

    @Id
    private Long userStoryId;
    @ManyToOne
    @JoinColumn(name = "sprint_id")
    private Sprint sprint;

    public SprintUserStory() {
    }

    public Sprint getProject() {
        return sprint;
    }

    public void setSprint(Sprint sprint) {
        this.sprint= sprint;
    }

    public Long getUserStoryId() {
        return userStoryId;
    }

    public void setUserStoryId(Long userStoryId) {
        this.userStoryId = userStoryId;
    }

    public void setIsolatedSprintId(Long sprintId) {
        Sprint sprint = new Sprint();
        sprint.setId(sprintId);
        this.sprint = sprint;
    }

    public SprintUserStoryDTO toDTO() {
        return new SprintUserStoryDTO.Builder()
                .withSprint(Objects.nonNull(sprint) ? sprint.toDTO(): null)
                .withUserStoryId(this.userStoryId)
                .build();
    }
}
