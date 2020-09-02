package com.sbs.userStories;

import com.sbs.contracts.dto.LabelDTO;
import com.sbs.contracts.dto.TaskDTO;
import com.sbs.contracts.dto.UserStoryDTO;
import com.sbs.userStories.services.LabelService;
import com.sbs.userStories.services.TaskService;
import com.sbs.userStories.services.UserStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserStoryController {

  @Autowired
  private UserStoryService userStoryService;

  @Autowired
  private TaskService taskService;

  @Autowired
  private LabelService labelService;

  @GetMapping(value = "/userstories", produces = MediaType.APPLICATION_JSON_VALUE)
  public Iterable<UserStoryDTO> getAllUsersStories() {
    return userStoryService.getAllUserStories();
  }

  @GetMapping(value = "/userstories", produces = MediaType.APPLICATION_JSON_VALUE, params = {"ids"})
  public Iterable<UserStoryDTO> getUserStoriesByIds(@RequestParam List<Long> ids) {
    return userStoryService.getByIds(ids);
  }

  @GetMapping(value = "/userstories/{userStoryId}")
  public UserStoryDTO getUserStory(@PathVariable Long userStoryId) {
    return userStoryService.getUserStoryById(userStoryId);
  }

  @PostMapping(value = "/userstories")
  public UserStoryDTO createUserStory(@RequestBody UserStoryDTO UserStoryDTO) {
    return userStoryService.createUserStory(UserStoryDTO);
  }

  @PutMapping(value = "/userstories/{userStoryId}")
  public UserStoryDTO updateUserStory(@RequestBody UserStoryDTO UserStoryDTO, @PathVariable Long userStoryId) {
    return userStoryService.updateUserStory(UserStoryDTO, userStoryId);
  }

  @DeleteMapping(value = "/userstories/{userStoryId}")
  public void deleteUserStory(@PathVariable Long userStoryId) {
    userStoryService.deleteUserStoById(userStoryId);
  }

  @GetMapping(value = "/userstories/{userStoryId}/tasks")
  public Iterable<TaskDTO> getAllTaks(@PathVariable Long userStoryId) {
    return taskService.getAll(userStoryId);
  }

  @GetMapping(value = "/userstories/{userStoryId}/tasks/{taskId}")
  public TaskDTO getTask(@PathVariable Long userStoryId, @PathVariable Long taskId) {
    return taskService.getById(userStoryId, taskId);
  }

  @PostMapping(value = "/userstories/{userStoryId}/tasks")
  public TaskDTO createTask(@PathVariable Long userStoryId, @RequestBody TaskDTO TaskDTO) {
    return taskService.create(userStoryId, TaskDTO);
  }

  @PutMapping(value = "/userstories/{userStoryId}/tasks/{taskId}")
  public TaskDTO updateTask(@PathVariable Long userStoryId, @PathVariable Long taskId, @RequestBody TaskDTO TaskDTO) {
    return taskService.updateUserStoryTask(userStoryId, taskId, TaskDTO);
  }

  @DeleteMapping(value = "/userstories/{userStoryId}/tasks/{taskId}")
  public void deleteTask(@PathVariable Long userStoryId, @PathVariable Long taskId) {
    taskService.deleteById(userStoryId, taskId);
  }

  @GetMapping(value = "/labels")
  public Iterable<LabelDTO> getAllLabels() {
    return labelService.getAll();
  }
}
