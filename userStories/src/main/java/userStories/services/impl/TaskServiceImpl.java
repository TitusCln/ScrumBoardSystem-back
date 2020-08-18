package userStories.services.impl;

import com.sbs.contracts.dto.TaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import userStories.models.TaskRepository;
import userStories.services.TaskService;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Iterable<TaskDTO> getAll(Long userStoryId) {
        return StreamSupport.stream(taskRepository.findByUserStoryId(userStoryId).spliterator(), false)
                .map(userStories.models.Task::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TaskDTO getById(Long userStoryTask, Long taskId) {
        return taskRepository.findById(taskId).get().toDTO();
    }

    @Override
    public TaskDTO create(Long userStoryId, TaskDTO newTask) {
        userStories.models.Task taskToSave = new userStories.models.Task(newTask);
        taskToSave.setIsolatedUserStory(userStoryId);
        return taskRepository.save(taskToSave).toDTO();
    }

    @Override
    public void deleteById(Long userStoryId, Long taskId) {
        taskRepository.deleteById(taskId);
    }

    @Override
    public TaskDTO updateUserStoryTask(Long userStoryId, Long taskId, TaskDTO updatedTask) {
        return taskRepository.findById(taskId)
                .map(TaskDTO -> {
                    TaskDTO.setDescription(updatedTask.getDescription());
                    TaskDTO.setDuration(updatedTask.getDuration());
                    return taskRepository.save(TaskDTO).toDTO();
                }).get();
    }
}
