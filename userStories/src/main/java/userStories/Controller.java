package userStories;

import com.sbs.dto.Task;
import com.sbs.dto.UserStory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import userStories.services.TaskService;
import userStories.services.UserStoryService;

@RestController
public class Controller {

    @Autowired
    private UserStoryService userStoryService;

    @Autowired
    private TaskService taskService;

    @GetMapping(value = "/userstories", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<UserStory> getAllUsersStories() {
        return userStoryService.getAllUserStories();
    }

    @GetMapping(value = "/userstories/{userStoryId}")
    public UserStory getUserStory(@PathVariable Long userStoryId) {
        return userStoryService.getUserStoryById(userStoryId);
    }

    @PostMapping(value = "/userstories")
    public UserStory createUserStory(@RequestBody UserStory userStory) {
        return userStoryService.createUserStory(userStory);
    }

    @PutMapping(value = "/userstories/{userStoryId}")
    public UserStory updateUserStory(@RequestBody UserStory userStory, @PathVariable Long userStoryId) {
        return userStoryService.updateUserStory(userStory, userStoryId);
    }

    @DeleteMapping(value = "/userstories/{userStoryId}")
    public void deleteUserStory(@PathVariable Long userStoryId) {
        userStoryService.deleteUserStoById(userStoryId);
    }

    @GetMapping(value = "/userstories/{userStoryId}/tasks")
    public Iterable<Task> getAllTaks(@PathVariable Long userStoryId) {
        return taskService.getAll(userStoryId);
    }

    @GetMapping(value = "/userstories/{userStoryId}/tasks/{taskId}")
    public Task getTask(@PathVariable Long userStoryId, @PathVariable Long taskId) {
        return taskService.getById(userStoryId, taskId);
    }

    @PostMapping(value = "/userstories/{userStoryId}/tasks")
    public Task createTask(@PathVariable Long userStoryId, @RequestBody Task task) {
        return taskService.create(userStoryId, task);
    }

    @PutMapping(value = "/userstories/{userStoryId}/tasks/{taskId}")
    public Task updateTask(@PathVariable Long userStoryId, @PathVariable Long taskId, @RequestBody Task task) {
        return taskService.updateUserStoryTask(userStoryId, taskId, task);
    }

    @DeleteMapping(value = "/userstories/{userStoryId}/tasks/{taskId}")
    public void deleteTask(@PathVariable Long userStoryId, @PathVariable Long taskId) {
        taskService.deleteById(userStoryId, taskId);
    }
}
