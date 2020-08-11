package userStories.service.impl;

import dto.UserStory;
import org.springframework.beans.factory.annotation.Autowired;
import userStories.models.UserStoryRepository;
import userStories.service.UserStoryService;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class UserStoryImpl implements UserStoryService {

    @Autowired
    private UserStoryRepository userStoryRepository;

    @Override
    public Iterable<UserStory> getAll() {
        return StreamSupport.stream(userStoryRepository.findAll().spliterator(),true)
                .map(userStories.models.UserStory::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserStory findById(Long id) {
        return userStoryRepository.findById(id).get().toDTO();
    }

    @Override
    public UserStory create(UserStory userStory) {
        return null;
    }

    @Override
    public void deleteById(Long id){
        userStoryRepository.deleteById(id);
    }

    @Override
    public UserStory update(UserStory updatedUserStory, Long id) {
        return userStoryRepository.findById(id)
                .map(userStory -> {
                    userStory.setTitle(updatedUserStory.getTitle());
                    userStory.setDescription(updatedUserStory.getDescription());
                    userStory.setWeight(updatedUserStory.getWeight());
                    return userStoryRepository.save(userStory).toDTO();
                }).get();
    }

}
