package userStories.service;

import com.sbs.dto.UserStory;

public interface UserStoryService {

    Iterable<UserStory> getAllUserStories();

    UserStory getUserStoryById(Long id);

    UserStory createUserStory(UserStory userStory);

    void deleteUserStoById(Long id);

    UserStory updateUserStory(UserStory userStory, Long id);

}
