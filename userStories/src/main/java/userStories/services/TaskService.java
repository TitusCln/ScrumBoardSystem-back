package userStories.services;

import com.sbs.contracts.dto.TaskDTO;

public interface TaskService {

    Iterable<TaskDTO> getAll(Long userStoryId);

    TaskDTO getById(Long userStoryTask, Long taskId);

    TaskDTO create(Long userStoryId, TaskDTO TaskDTO);

    void deleteById(Long userStoryId, Long taskId);

    TaskDTO updateUserStoryTask(Long userStoryId, Long taskId, TaskDTO TaskDTO);
}
