package userStories.service;

import dto.UserStory;

public interface UserStoryService {

    Iterable<UserStory> getAll();
    UserStory findById(Long id);
    UserStory create(UserStory userStory);
    void deleteById(Long id);
    UserStory update(UserStory userStory,Long id);
}
