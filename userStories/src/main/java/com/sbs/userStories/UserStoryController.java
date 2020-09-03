package com.sbs.userStories;

import com.sbs.contracts.dto.LabelDTO;
import com.sbs.contracts.dto.TaskDTO;
import com.sbs.contracts.dto.UserStoryDTO;

import java.util.List;

public interface UserStoryController {

    /**
     * Gets all User Stories
     *
     * @return the DTO USer Stories Objects
     */
    Iterable<UserStoryDTO> getAllUsersStories();

    /**
     * Gets all the Users Stories that match the <code>ids</code> criteria
     *
     * @param ids the list of IDS to be fetched
     * @return the Users Stories DTO objects that match the criteria
     */
    Iterable<UserStoryDTO> getUserStoriesByIds(List<Long> ids);

    /**
     * Gets the User Story by its <code>userStoryId</code>
     *
     * @param userStoryId the requested User Story ID
     * @return the DTO User Story Object
     */
    UserStoryDTO getUserStory(Long userStoryId);

    /**
     * Creates the User Story
     *
     * @param UserStoryDTO the DTO Object with the data to be created
     * @return the DTO User Story created
     */
    UserStoryDTO createUserStory(UserStoryDTO UserStoryDTO);

    /**
     * Updates the User Story with the <code>userStoryId</code> specified
     *
     * @param UserStoryDTO the DTO Object with the new data
     * @param userStoryId  the requested User Story ID
     * @return the DTO User Story updated
     */
    UserStoryDTO updateUserStory(UserStoryDTO UserStoryDTO, Long userStoryId);

    /**
     * Deletes the User Story identified by its <code>userStoryId</code>
     *
     * @param userStoryId the requested User Story ID to be deleted
     */
    void deleteUserStory(Long userStoryId);

    /**
     * Gets all the User Stories's Tasks within the <code>userStoryId</code>
     *
     * @param userStoryId the related User Story ID
     * @return the TaskDTO Objects
     */
    Iterable<TaskDTO> getAllTaks(Long userStoryId);

    /**
     * Gets the specified Task's with the <code>taskId</code> related to the
     * User Story with the <code>userStoryId</code>
     *
     * @param userStoryId the related User Story ID
     * @param taskId      the requested Task ID to be fetched
     * @return the TaskDTO Object
     */
    TaskDTO getTask(Long userStoryId, Long taskId);

    /**
     * Creates a new User Story's Task related to the specified <code>userStoryId</code>
     *
     * @param userStoryId the related User Story ID
     * @param TaskDTO     the DTO Object created
     * @return the created DTO Task Object
     */
    TaskDTO createTask(Long userStoryId, TaskDTO TaskDTO);

    /**
     * Updates the User Story's Task with the <code>taskId</code> related to the
     * <code>userStoryId</code>
     *
     * @param userStoryId the related User Story ID
     * @param taskId      the requested Task ID to be updated
     * @param TaskDTO     the DTO Task Object with the new data
     * @return the updated DTO Task Object
     */
    TaskDTO updateTask(Long userStoryId, Long taskId, TaskDTO TaskDTO);

    /**
     * Deletes the User Story's Task with the <code>taskId</code> related to the
     * <code>userStoryId</code>
     *
     * @param userStoryId the related User Story ID
     * @param taskId      the requested Task ID to be deleted
     */
    void deleteTask(Long userStoryId, Long taskId);

    /**
     * Gets all the labels saved
     *
     * @return all the labelDTO objects saved
     */
    Iterable<LabelDTO> getAllLabels();
}
