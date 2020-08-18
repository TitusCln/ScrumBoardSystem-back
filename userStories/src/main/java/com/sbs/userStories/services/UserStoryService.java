package com.sbs.userStories.services;

import com.sbs.contracts.dto.UserStoryDTO;

public interface UserStoryService {

    Iterable<UserStoryDTO> getAllUserStories();

    UserStoryDTO getUserStoryById(Long id);

    UserStoryDTO createUserStory(UserStoryDTO userStory);

    void deleteUserStoById(Long id);

    UserStoryDTO updateUserStory(UserStoryDTO userStory, Long id);

}
