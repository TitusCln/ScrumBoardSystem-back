package com.sbs.projects.services;

import com.sbs.contracts.dto.ProjectDTO;
import com.sbs.contracts.dto.SprintUserStoryDTO;
import com.sbs.contracts.dto.UserStoryDTO;

public interface ProjectService {

    /**
     * Gets all Projects created
     *
     * @param withSprints flag to specify whether the Sprints are returned or not
     * @return the DTO Project Objects
     */
    Iterable<ProjectDTO> getAll(Boolean withSprints);

    /**
     * Gets the Project with the specified <code>id</code>
     *
     * @param id          the requested Project ID
     * @param withSprints flag to specify whether the Sprints are returned or not
     * @return the DTO Project Object
     */
    ProjectDTO getById(Long id, Boolean withSprints);

    /**
     * Creates a new Project
     *
     * @param ProjectDTO the DTO Project Object with the data to be created
     * @return the DTO Project Object created
     */
    ProjectDTO create(ProjectDTO ProjectDTO);

    /**
     * Updates a Project with the specified <code>id</code>
     *
     * @param id         the requested Project ID
     * @param ProjectDTO the DTO Project Object to be updated
     * @return the DTO Project Object updated
     */
    ProjectDTO update(Long id, ProjectDTO ProjectDTO);

    /**
     * Deletes the Project with the specified <code>id</code>
     *
     * @param id the requested Project ID
     */
    void deleteById(Long id);

    /**
     * Creates a Project's User Story and create the relationships between them
     *
     * @param projectId    the related Project ID
     * @param userStoryDTO the DTO User Story with the new Data
     * @return the DTO User Story Object created
     */
    UserStoryDTO createProjectUserStory(Long projectId, UserStoryDTO userStoryDTO);

    /**
     * Gets the Project's User Stories related to a particular Project defined by the <code>projectId</code>
     *
     * @param projectId the related Project ID
     * @return the DTO User Stories Objects
     */
    Iterable<UserStoryDTO> getProjectUserStories(Long projectId);

    /**
     * Deletes a Project's User Story and the relationship between them
     *
     * @param projectId   The related Project ID
     * @param userStoryId the requested User Story to be deleted
     */
    void deleteProjectUserStory(Long projectId, Long userStoryId);

    /**
     * Get the Sprint and User Story relationship specified by the <code>userStoryId</code>
     *
     * @param userStoryId the User Story Id requested
     * @return the relationship between the Sprint and te requested User Story
     */
    SprintUserStoryDTO getSprintUserStoryByUserStoryId(Long userStoryId);

}
