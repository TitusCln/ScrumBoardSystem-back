package userStories.service.impl;

import com.sbs.dto.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import userStories.models.TaskRepository;
import userStories.models.UserStory;
import userStories.models.UserStoryRepository;
import userStories.service.TaskService;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserStoryRepository userStoryRepository;

    @Override
    public Iterable<Task> getAll(Long userStoryId) {
        return StreamSupport.stream(taskRepository.findByUserStoryId(userStoryId).spliterator(), false)
                .map(userStories.models.Task::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Task getById(Long userStoryTask, Long taskId) {
        return taskRepository.findById(taskId).get().toDTO();
    }

    @Override
    public Task create(Long userStoryId, Task newTask) {
        UserStory userStory = userStoryRepository.findById(userStoryId).get();
        userStories.models.Task taskToSave = new userStories.models.Task(newTask);
        taskToSave.setUserStory(userStory);
        return taskRepository.save(taskToSave).toDTO();
    }

    @Override
    public void deleteById(Long userStoryId, Long taskId) {
        taskRepository.deleteById(taskId);
    }

    @Override
    public Task updateUserStoryTask(Long userStoryId, Long taskId, Task updatedTask) {
        return taskRepository.findById(taskId)
                .map(task -> {
                    task.setDescription(updatedTask.getDescription());
                    task.setDuration(updatedTask.getDuration());
                    return taskRepository.save(task).toDTO();
                }).get();
    }
}
