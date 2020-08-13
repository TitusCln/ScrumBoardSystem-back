package userStories.service.impl;

import com.sbs.dto.UserStory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import userStories.models.Label;
import userStories.models.UserStoryRepository;
import userStories.service.UserStoryService;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserStoryImpl implements UserStoryService {

    @Autowired
    private UserStoryRepository userStoryRepository;

    @Override
    public Iterable<UserStory> getAllUserStories() {
        return StreamSupport.stream(userStoryRepository.findAll().spliterator(), false)
                .map(userStories.models.UserStory::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserStory getUserStoryById(Long id) {
        return userStoryRepository.findById(id).get().toDTO();
    }

    @Override
    public UserStory createUserStory(UserStory userStory) {
        userStories.models.UserStory userStoryToSave = new userStories.models.UserStory(userStory);
        return userStoryRepository.save(userStoryToSave).toDTO();
    }

    @Override
    public void deleteUserStoById(Long id) {
        userStoryRepository.deleteById(id);
    }

    @Override
    public UserStory updateUserStory(UserStory updatedUserStory, Long id) {
        return userStoryRepository.findById(id)
                .map(userStory -> {
                    userStory.setTitle(updatedUserStory.getTitle());
                    userStory.setDescription(updatedUserStory.getDescription());
                    userStory.setWeight(updatedUserStory.getWeight());
                    userStory.setLabels(Optional.ofNullable(updatedUserStory.getLabels()).stream()
                            .flatMap(Collection::parallelStream)
                            .map(Label::new)
                            .collect(Collectors.toSet()));
                    userStory.setTasks(Optional.ofNullable(updatedUserStory.getTasks()).stream()
                            .flatMap(Collection::parallelStream)
                            .map(userStories.models.Task::new)
                            .collect(Collectors.toSet()));
                    return userStoryRepository.save(userStory).toDTO();
                }).get();
    }

//    private Stream<S> getOptionalSteam(Collection<T> iterable){
//        return Optional.ofNullable(iterable).stream().flatMap(Collection::parallelStream);
//    }

}
