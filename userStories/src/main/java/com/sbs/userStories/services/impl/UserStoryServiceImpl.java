package com.sbs.userStories.services.impl;

import com.sbs.contracts.dto.UserStoryDTO;
import com.sbs.userStories.models.Label;
import com.sbs.userStories.models.LabelRepository;
import com.sbs.userStories.models.Task;
import com.sbs.userStories.models.UserStory;
import com.sbs.userStories.models.UserStoryRepository;
import com.sbs.userStories.services.UserStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static java.util.Objects.nonNull;

@Service
public class UserStoryServiceImpl implements UserStoryService {

    @Autowired
    private UserStoryRepository userStoryRepository;
    @Autowired
    private LabelRepository labelRepository;

    @Override
    public Iterable<UserStoryDTO> getAllUserStories() {
        return StreamSupport.stream(userStoryRepository.findAll().spliterator(), false)
                .map(UserStory::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserStoryDTO getUserStoryById(Long id) {
        return userStoryRepository.findById(id).get().toDTO();
    }

    @Override
    public UserStoryDTO createUserStory(UserStoryDTO userStory) {
        Set<Label> labels = userStory.getLabels().stream().map(labelDTO -> {
            if (nonNull(labelDTO.getId()))
                return labelRepository.findById(labelDTO.getId()).get();
            return new Label(labelDTO);
        }).collect(Collectors.toSet());

        UserStory userStoryToSave = new UserStory(userStory);
        userStoryToSave.setLabels(labels);
        return userStoryRepository.save(userStoryToSave).toDTO();
    }

  @Override
  public void deleteUserStoById(Long id) {
    userStoryRepository.deleteById(id);
  }

  @Override
  public UserStoryDTO updateUserStory(UserStoryDTO updatedUserStory, Long id) {
    return userStoryRepository.findById(id)
        .map(userStory -> {
          userStory.setTitle(updatedUserStory.getTitle());
          userStory.setDescription(updatedUserStory.getDescription());
          userStory.setWeight(updatedUserStory.getWeight());
          userStory.setLabels(Optional.ofNullable(updatedUserStory.getLabels())
              .orElse(new HashSet<>())
              .parallelStream()
              .map(Label::new)
                  .collect(Collectors.toSet()));
            userStory.setTasks(Optional.ofNullable(updatedUserStory.getTasks())
                    .orElse(new HashSet<>())
                    .parallelStream()
                    .map(Task::new)
                    .collect(Collectors.toSet()));
            return userStoryRepository.save(userStory).toDTO();
        }).get();
  }

    @Override
    public Iterable<UserStoryDTO> getByIds(Iterable<Long> ids) {
        return StreamSupport.stream(userStoryRepository.findAllById(ids).spliterator(), true)
                .map(UserStory::toDTO)
                .collect(Collectors.toList());
    }

}
