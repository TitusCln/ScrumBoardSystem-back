package com.sbs.userStories.services;

import com.sbs.contracts.dto.LabelDTO;
import com.sbs.contracts.dto.TaskDTO;
import com.sbs.contracts.dto.UserStoryDTO;

import java.util.List;

public interface UserStoryController {

    Iterable<UserStoryDTO> getAllUsersStories();

    Iterable<UserStoryDTO> getUserStoriesByIds(List<Long> ids);

    UserStoryDTO getUserStory(Long userStoryId);

    UserStoryDTO createUserStory(UserStoryDTO UserStoryDTO);

    UserStoryDTO updateUserStory(UserStoryDTO UserStoryDTO, Long userStoryId);

    void deleteUserStory(Long userStoryId);

    Iterable<TaskDTO> getAllTaks(Long userStoryId);

    TaskDTO getTask(Long userStoryId, Long taskId);

    TaskDTO createTask(Long userStoryId, TaskDTO TaskDTO);

    TaskDTO updateTask(Long userStoryId, Long taskId, TaskDTO TaskDTO);

    void deleteTask(Long userStoryId, Long taskId);

    Iterable<LabelDTO> getAllLabels();
}
