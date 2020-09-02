package com.sbs.contracts.clients;

import com.sbs.contracts.dto.TaskDTO;
import com.sbs.contracts.dto.UserStoryDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "userStory", url = "${endpoint-userstory-service}")
public interface UserStoryProxy {
  static final String prefix = "/userstories";

  /**
   * Gets all User Stories
   *
   * @return the DTO USer Stories Objects
   */
  @RequestMapping(method = RequestMethod.GET, value = prefix)
  Iterable<UserStoryDTO> getAllUsersStories();

  /**
   * Creates the User Story
   *
   * @param userStoryDTO the DTO Object with the data to be created
   * @return the DTO User Story created
   */
  @RequestMapping(method = RequestMethod.POST, value = prefix)
  UserStoryDTO createUserStory(@RequestBody UserStoryDTO userStoryDTO);

  /**
   * Updates the User Story with the <code>userStoryId</code> specified
   *
   * @param userStoryDTO the DTO Object with the new data
   * @param userStoryId  the requested User Story ID
   * @return the DTO User Story updated
   */
  @RequestMapping(method = RequestMethod.PUT, value = prefix + "/{userStoryId}")
  UserStoryDTO updateUserStory(@PathVariable(value = "userStoryId") Long userStoryId, @RequestBody UserStoryDTO userStoryDTO);

  /**
   * Deletes the User Story identified by its <code>userStoryId</code>
   *
   * @param userStoryId the requested User Story ID to be deleted
   */
  @RequestMapping(method = RequestMethod.DELETE, value = prefix + "/{userStoryId}")
  void deleteUserStory(@PathVariable(value = "userStoryId") Long userStoryId);

  /**
   * Gets all the User Stories's Tasks within the <code>userStoryId</code>
   *
   * @param userStoryId the related User Story ID
   * @return the TaskDTO Objects
   */
  @RequestMapping(method = RequestMethod.GET, value = prefix + "/{userStoryId}/tasks")
  Iterable<TaskDTO> getAllTasks(@PathVariable(value = "userStoryId") Long userStoryId);

  /**
   * Gets the specified Task's with the <code>taskId</code> related to the
   * User Story with the <code>userStoryId</code>
   *
   * @param userStoryId the related User Story ID
   * @param taskId      the requested Task ID to be fetched
   * @return the TaskDTO Object
   */
  @RequestMapping(method = RequestMethod.GET, value = prefix + "/{userStoryId}/tasks/{taskId}")
  TaskDTO getTask(@PathVariable(value = "userStoryId") Long userStoryId, @PathVariable(value = "taskId") Long taskId);

  /**
   * Creates a new User Story's Task related to the specified <code>userStoryId</code>
   *
   * @param userStoryId the related User Story ID
   * @param TaskDTO     the DTO Object created
   * @return the created DTO Task Object
   */
  @RequestMapping(method = RequestMethod.POST, value = prefix + "/{userStoryId}/tasks")
  TaskDTO createTask(@PathVariable(value = "userStoryId") Long userStoryId, @RequestBody TaskDTO TaskDTO);

  /**
   * Updates the User Story's Task with the <code>taskId</code> related to the
   * <code>userStoryId</code>
   *
   * @param userStoryId the related User Story ID
   * @param taskId      the requested Task ID to be updated
   * @param TaskDTO     the DTO Task Object with the new data
   * @return the updated DTO Task Object
   */
  @RequestMapping(method = RequestMethod.PUT, value = prefix + "/{userStoryId}/tasks/{taskId}")
  public TaskDTO updateTask(@PathVariable(value = "userStoryId") Long userStoryId, @PathVariable(value = "taskId") Long taskId, @RequestBody TaskDTO TaskDTO);

  /**
   * Deletes the User Story's Task with the <code>taskId</code> related to the
   * <code>userStoryId</code>
   *
   * @param userStoryId the related User Story ID
   * @param taskId      the requested Task ID to be deleted
   */
  @RequestMapping(method = RequestMethod.DELETE, value = prefix + "/{userStoryId}/tasks/{taskId}")
  public void deleteTask(@PathVariable(value = "userStoryId") Long userStoryId, @PathVariable(value = "taskId") Long taskId);

  /**
   * Gets all the Users Stories that match the <code>ids</code> criteria
   *
   * @param ids the list of IDS to be fetched
   * @return the Users Stories DTO objects that match the criteria
   */
  @RequestMapping(method = RequestMethod.GET, value = prefix, params = {"ids"})
  public Iterable<UserStoryDTO> getUserStoriesByIds(@RequestParam(value = "ids") List<Long> ids);
}
