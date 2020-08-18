package com.sbs.contracts.clients;

import com.sbs.contracts.dto.TaskDTO;
import com.sbs.contracts.dto.UserStoryDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "userStory", url = "${endpoint-userstory-service}")
public interface UserStoryFeign {
  static final String prefix = "/userstories";

  @RequestMapping(method = RequestMethod.GET, value = prefix)
  Iterable<UserStoryDTO> getAllUsersStories();

  @RequestMapping(method = RequestMethod.POST, value = prefix)
  UserStoryDTO createUserStory(@RequestBody UserStoryDTO userStoryDTO);

  @RequestMapping(method = RequestMethod.PUT, value = prefix + "/{userStoryId}")
  UserStoryDTO updateUserStory(@PathVariable Long userStoryId, @RequestBody UserStoryDTO userStoryDTO);

  @RequestMapping(method = RequestMethod.DELETE, value = prefix + "/{userStoryId}")
  void deleteUserStory(@PathVariable Long userStoryId);

  @RequestMapping(method = RequestMethod.GET, value = prefix + "/{userStoryId}/tasks")
  Iterable<TaskDTO> getAllTasks(@PathVariable Long userStoryId);

  @RequestMapping(method = RequestMethod.GET, value = prefix + "/{userStoryId}/tasks/{taskId}")
  TaskDTO getTask(@PathVariable Long userStoryId, @PathVariable Long taskId);

  @RequestMapping(method = RequestMethod.POST, value = prefix + "/{userStoryId}/tasks")
  TaskDTO createTask(@PathVariable Long userStoryId, @RequestBody TaskDTO TaskDTO);

  @RequestMapping(method = RequestMethod.PUT, value = prefix + "/{userStoryId}/tasks/{taskId}")
  public TaskDTO updateTask(@PathVariable Long userStoryId, @PathVariable Long taskId, @RequestBody TaskDTO TaskDTO);

  @RequestMapping(method = RequestMethod.DELETE, value = prefix + "/{userStoryId}/tasks/{taskId}")
  public void deleteTask(@PathVariable Long userStoryId, @PathVariable Long taskId);
}
