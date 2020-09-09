package com.sbs.userStories.services.impl;

import com.sbs.contracts.dto.TaskDTO;
import com.sbs.userStories.models.Task;
import com.sbs.userStories.models.TaskRepository;
import com.sbs.userStories.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Iterable<TaskDTO> getAll(Long userStoryId) {
        return StreamSupport.stream(taskRepository.findByUserStoryId(userStoryId).spliterator(), false)
                .map(Task::toDTO)
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public TaskDTO getById(Long userStoryTask, Long taskId) {
        return taskRepository.findById(taskId).get().toDTO();
    }

    @Override
    public TaskDTO create(Long userStoryId, TaskDTO newTask) {
        Task taskToSave = new Task(newTask);
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
                .map(Task -> {
                    Task.setDescription(updatedTask.getDescription());
                    Task.setDuration(updatedTask.getDuration());
                    Task.setDone(updatedTask.getDone());
                    Task.setOrder(updatedTask.getOrder());
                    return taskRepository.save(Task).toDTO();
                }).get();
    }
}
