package com.sbs.userStories.services;

import com.sbs.contracts.dto.TaskDTO;

public interface TaskService {

    /**
     * Gets all the User Stories's Tasks within the <code>userStoryId</code>
     *
     * @param userStoryId the related User Story ID
     * @return the TaskDTO Objects
     */
    Iterable<TaskDTO> getAll(Long userStoryId);

    /**
     * Gets the specified Task's with the <code>taskId</code> related to the
     * User Story with the <code>userStoryId</code>
     *
     * @param userStoryId the related User Story ID
     * @param taskId      the requested Task ID to be fetched
     * @return the TaskDTO Object
     */
    TaskDTO getById(Long userStoryId, Long taskId);

    /**
     * Creates a new User Story's Task related to the specified <code>userStoryId</code>
     *
     * @param userStoryId the related User Story ID
     * @param TaskDTO     the DTO Object created
     * @return the created DTO Task Object
     */
    TaskDTO create(Long userStoryId, TaskDTO TaskDTO);

    /**
     * Deletes the User Story's Task with the <code>taskId</code> related to the
     * <code>userStoryId</code>
     *
     * @param userStoryId the related User Story ID
     * @param taskId      the requested Task ID to be deleted
     */
    void deleteById(Long userStoryId, Long taskId);

    /**
     * Updates the User Story's Task with the <code>taskId</code> related to the
     * <code>userStoryId</code>
     *
     * @param userStoryId the related User Story ID
     * @param taskId      the requested Task ID to be updated
     * @param TaskDTO     the DTO Task Object with the new data
     * @return the updated DTO Task Object
     */
    TaskDTO updateUserStoryTask(Long userStoryId, Long taskId, TaskDTO TaskDTO);
}
