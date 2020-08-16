package userStories.service;

import com.sbs.dto.Task;

public interface TaskService {

    Iterable<Task> getAll(Long userStoryId);

    Task getById(Long userStoryTask, Long taskId);

    Task create(Long userStoryId, Task task);

    void deleteById(Long userStoryId, Long taskId);

    Task updateUserStoryTask(Long userStoryId, Long taskId, Task task);
}
