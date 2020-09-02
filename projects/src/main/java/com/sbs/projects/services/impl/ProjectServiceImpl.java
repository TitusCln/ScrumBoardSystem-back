package com.sbs.projects.services.impl;

import com.sbs.contracts.clients.UserStoryProxy;
import com.sbs.contracts.dto.ProjectDTO;
import com.sbs.contracts.dto.SprintUserStoryDTO;
import com.sbs.contracts.dto.UserStoryDTO;
import com.sbs.projects.models.ProjectRespository;
import com.sbs.projects.models.ProjectUserStory;
import com.sbs.projects.models.ProjectUserStoryRepository;
import com.sbs.projects.models.SprintUserStory;
import com.sbs.projects.models.SprintUserStoryRepository;
import com.sbs.projects.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static java.util.Objects.nonNull;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRespository projectRespository;

    @Autowired
    private ProjectUserStoryRepository projectUserStoryRepository;

    @Autowired
    private SprintUserStoryRepository sprintUserStoryRepository;

    @Autowired
    private UserStoryProxy userStoryProxy;

    @Override
    public Iterable<ProjectDTO> getAll(Boolean witSprints) {

        return StreamSupport.stream(projectRespository.findAll().spliterator(), true)
                .map(project -> project.toDTO(witSprints))
                .collect(Collectors.toList());
    }

    @Override
    public ProjectDTO getById(Long id, Boolean withSprints) {
        return projectRespository.findById(id).get().toDTO();
    }

    @Override
    public ProjectDTO create(ProjectDTO project) {
        return projectRespository.save(new com.sbs.projects.models.Project(project)).toDTO();
    }

    @Override
    public ProjectDTO update(Long id, ProjectDTO newProject) {
        return projectRespository.findById(id).map(project -> {
            project.setName(newProject.getName());
            return projectRespository.save(project).toDTO();
        }).get();
    }

    @Override
    public void deleteById(Long id) {
        projectRespository.deleteById(id);
    }

    @Override
    public UserStoryDTO createProjectUserStory(Long projectId, UserStoryDTO userStoryDTO) {
        UserStoryDTO storyCreated = userStoryProxy.createUserStory(userStoryDTO);
        ProjectUserStory projectUserStory = new ProjectUserStory();
        projectUserStory.setIsolatedProjectId(projectId);
        projectUserStory.setUserStoryId(storyCreated.getId());
        projectUserStoryRepository.save(projectUserStory);
        if (nonNull(userStoryDTO.getSprint()) && nonNull(userStoryDTO.getSprint().getId())) {
            SprintUserStory sprintUserStory = new SprintUserStory();
            sprintUserStory.setUserStoryId(storyCreated.getId());
            sprintUserStory.setIsolatedSprintId(userStoryDTO.getSprint().getId());
            sprintUserStoryRepository.save(sprintUserStory);
        }
        return storyCreated;
    }

    @Override
    public Iterable<UserStoryDTO> getProjectUserStories(Long projectId) {
        List<Long> sprintIds = StreamSupport.stream(projectUserStoryRepository.findByProjectId(projectId).spliterator(), true)
                .map(ProjectUserStory::getUserStoryId)
                .collect(Collectors.toList());
        return StreamSupport.stream( userStoryProxy.getUserStoriesByIds(sprintIds).spliterator(), false)
            .map(userStory -> {
                    userStory.setSprint(getSprintUserStoryByUserStoryId(userStory.getId()).getSprntDTO());
                    return userStory;
                }).collect(Collectors.toList());
    }

    @Override
    public void deleteProjectUserStory(Long projectId, Long userStoryId) {
        projectUserStoryRepository.deleteById(userStoryId);
        userStoryProxy.deleteUserStory(userStoryId);
    }

    @Override
    public SprintUserStoryDTO getSprintUserStoryByUserStoryId(Long userStoryId){
        return sprintUserStoryRepository.findById(userStoryId).orElse(new SprintUserStory()).toDTO();
    }
}
