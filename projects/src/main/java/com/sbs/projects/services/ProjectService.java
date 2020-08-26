package com.sbs.projects.services;

import com.sbs.contracts.dto.ProjectDTO;
import com.sbs.contracts.dto.SprintUserStoryDTO;
import com.sbs.contracts.dto.UserStoryDTO;

public interface ProjectService {

    Iterable<ProjectDTO> getAll(Boolean withSprints);

    ProjectDTO getById(Long id, Boolean withSprints);

    ProjectDTO create(ProjectDTO ProjectDTO);

    ProjectDTO update(Long id, ProjectDTO ProjectDTO);

    void deleteById(Long id);

    UserStoryDTO createProjectUserStory(Long projectId, UserStoryDTO userStoryDTO);

    Iterable<UserStoryDTO> getProjectUserStories(Long projectId);

    void deleteProjectUserStory(Long projectId, Long userStoryId);

    SprintUserStoryDTO getSprintUserStoryByUserStoryId(Long userStoryId);

}
