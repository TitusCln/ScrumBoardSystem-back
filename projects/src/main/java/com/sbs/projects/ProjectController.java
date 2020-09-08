package com.sbs.projects;

import com.sbs.contracts.dto.ProjectDTO;
import com.sbs.contracts.dto.SprintDTO;
import com.sbs.contracts.dto.SprintUserStoryDTO;
import com.sbs.contracts.dto.UserStoryDTO;

public interface ProjectController {

    /**
     * Gets all projects created and Sprints if <code>withSprints</code> it's set to <code>true</code>
     *
     * @param withSprints the optional attribute to return Sprints DTO related to the project
     * @return the DTO Project Objects Iterable<ProjectDTO>
     */
    Iterable<ProjectDTO> getAllProjects(Boolean withSprints);

    /**
     * Gets the Project with the specified <code>projectId</code>
     *
     * @param projectId   the requested Project ID to be fetched
     * @param withSprints the optional attribute to return Sprints DTO related to the project
     * @return the DTO Project Object
     */
    ProjectDTO getProjectById(Long projectId, Boolean withSprints);

    /**
     * Creates a new Project
     *
     * @param project the DTO Project with the data to be created
     * @return the DTO Project created
     */
    ProjectDTO createProject(ProjectDTO project);

    /**
     * Updates the Project with the specified <code>projectId</code>
     *
     * @param projectId the requested Project ID to be updated
     * @param project   the DTO Project with the data to be updates
     * @return the DTO Project object with the new set of data
     */
    ProjectDTO updateProject(Long projectId, ProjectDTO project);

    /**
     * Deletes the Project with the specified <code>projectId</code>
     *
     * @param projectId the requested Project ID to be deleted
     */
    void deleteProject(Long projectId);

    /**
     * Gets all the sprints related to a Project by the <code>projectId</code> attribute
     *
     * @param projectId the Project ID related to the requested sprints
     * @return the DTO Sprint Objects iterable<SprintDTO>
     */
    Iterable<SprintDTO> getAllSprints(Long projectId);

    /**
     * Get the Project's sprint with the specified <code>sprintId</code>
     *
     * @param projectId the Project ID related to the requested sprint
     * @param sprintId  the requested Sprint ID
     * @return the DTO Sprint Object
     */
    SprintDTO getSprint(Long projectId, Long sprintId);

    /**
     * Creates a new Sprint related to the Project with the specified <code>projectId</code>
     *
     * @param projectId the Project ID related to the new sprint
     * @param sprint    the DTO Sprint with the data to be created
     * @return the DTO Sprint Object
     */
    SprintDTO createSprint(Long projectId, SprintDTO sprint);

    /**
     * Updates the Sprint related with the specified <code>sprintId</code>
     *
     * @param projectId the Project ID related to the sprint
     * @param sprintId  the Sprint ID to be updated
     * @param sprint    the Sprint DTO with the new set of data to be updated
     * @return the DTO Sprint Object
     */
    SprintDTO updateSprint(Long projectId, Long sprintId, SprintDTO sprint);

    /**
     * Deletes the Sprint specified by the <code>sprintId</code>
     *
     * @param projectId the Project ID related to the sprint
     * @param sprintId  the Sprint ID to be deleted
     */
    void deleteSprint(Long projectId, Long sprintId);

    /**
     * Gets the Project's User Stories related to the <code>projectId</code>
     *
     * @param projectId the requested Project ID
     * @return the DTO User Stories Object related to the project
     */
    Iterable<UserStoryDTO> getProjectUserStories(Long projectId);

    /**
     * Creates a new User Story related to the Project identified by <code>projectId</code>
     * and creates its relationship
     *
     * @param projectId    the related Project ID
     * @param userStoryDTO the DTO User Story with the data to be created
     * @return the created DTO User Story
     */
    UserStoryDTO createProjectUserStory(Long projectId, UserStoryDTO userStoryDTO);

    /**
     * Deletes the User Story identified by the <code>userStoryId</code> and the relation between its Project
     *
     * @param projectId   the related Project ID
     * @param userStoryId the request User Story ID to be deleted
     */
    void deleteProjectUserStory(Long projectId, Long userStoryId);

    /**
     * Get the Sprint and User Story relationship specified by the <code>userStoryId</code>
     *
     * @param userStoryId the User Story Id requested
     * @return the relationship between the Sprint and te requested User Story
     */
    SprintUserStoryDTO getSprintByUserStoryId(Long userStoryId);
}
