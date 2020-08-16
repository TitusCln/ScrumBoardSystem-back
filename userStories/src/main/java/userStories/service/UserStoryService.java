package userStories.service;

import com.sbs.dto.UserStory;

public interface UserStoryService {

    Iterable<UserStory> getAll();
    UserStory findById(Long id);
    UserStory create(UserStory userStory);
    void deleteById(Long id);
    UserStory update(UserStory userStory,Long id);
}
