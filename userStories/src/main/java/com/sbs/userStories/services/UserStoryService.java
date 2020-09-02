package com.sbs.userStories.services;

import com.sbs.contracts.dto.UserStoryDTO;

public interface UserStoryService {

    /**
     * Gets all User Stories
     *
     * @return the DTO USer Stories Objects
     */
    Iterable<UserStoryDTO> getAllUserStories();

    /**
     * Gets the User Story by its <code>id</code>
     *
     * @param id the requested User Story ID
     * @return the DTO User Story Object
     */
    UserStoryDTO getUserStoryById(Long id);

    /**
     * Creates the User Story
     *
     * @param userStory the DTO Object with the data to be created
     * @return the DTO User Story created
     */
    UserStoryDTO createUserStory(UserStoryDTO userStory);

    /**
     * Deletes the User Story identified by its <code>id</code>
     *
     * @param id the requested User Story ID to be deleted
     */
    void deleteUserStoById(Long id);

    /**
     * Updates the User Story with the <code>id</code> specified
     *
     * @param userStory the DTO Object with the new data
     * @param id        the requested User Story ID
     * @return the DTO User Story updated
     */
    UserStoryDTO updateUserStory(UserStoryDTO userStory, Long id);

    /**
     * Gets all the Users Stories that match the <code>ids</code> criteria
     *
     * @param ids the list of IDS to be fetched
     * @return the Users Stories DTO objects that match the criteria
     */
    Iterable<UserStoryDTO> getByIds(Iterable<Long> ids);

}
