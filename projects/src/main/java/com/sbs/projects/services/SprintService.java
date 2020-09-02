package com.sbs.projects.services;

import com.sbs.contracts.dto.SprintDTO;

public interface SprintService {

    /**
     * Gets all the Sprints created within a Project
     *
     * @param projectId the related Project ID
     * @return the Sprint DTO Objects
     */
    Iterable<SprintDTO> getAll(Long projectId);

    /**
     * Gets the Sprint specified with the <code>sprintId</code>
     *
     * @param projectId the related Project ID
     * @param sprintId  the requested Sprint ID to be fetched
     * @return the Sprint DTO Object
     */
    SprintDTO getById(Long projectId, Long sprintId);

    /**
     * Creates a new Sprint within a Project related
     *
     * @param projectId the related Project ID
     * @param SprintDTO the DTO Sprint with the data
     * @return the DTO Sprint Object created
     */
    SprintDTO create(Long projectId, SprintDTO SprintDTO);

    /**
     * Updates the Sprint with the <code>sprintId</code>
     *
     * @param projectId the related Project ID
     * @param sprintId  the requested Sprint ID to be updated
     * @param SprintDTO the DTO Sprint Object with the new data
     * @return the Sprint DTO Object updated
     */
    SprintDTO update(Long projectId, Long sprintId, SprintDTO SprintDTO);

    /**
     * Deletes the Sprint with the specified <code>sprintId</code>
     *
     * @param projectId the related Project ID
     * @param sprintId  the requested Sprint ID to be deleted
     */
    void delete(Long projectId, Long sprintId);
}
