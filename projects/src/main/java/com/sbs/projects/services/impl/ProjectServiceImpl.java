package com.sbs.projects.services.impl;

import com.sbs.contracts.clients.UserStoryProxy;
import com.sbs.contracts.dto.ProjectDTO;
import com.sbs.contracts.dto.UserStoryDTO;
import com.sbs.projects.models.ProjectRespository;
import com.sbs.projects.models.ProjectSprint;
import com.sbs.projects.models.ProjectSprintRepository;
import com.sbs.projects.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRespository projectRespository;

    @Autowired
    private ProjectSprintRepository projectSprintRepository;

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
        ProjectSprint projectSprint = new ProjectSprint();
        projectSprint.setIsolatedProjectId(projectId);
        projectSprint.setSprintId(storyCreated.getId());
        projectSprintRepository.save(projectSprint);
        return storyCreated;
    }

    @Override
    public Iterable<UserStoryDTO> getProjectsUserStory(Long projectId) {
        List<Long> sprintIds = StreamSupport.stream(projectSprintRepository.findByProjectId(projectId).spliterator(), true)
                .map(ProjectSprint::getSprintId)
                .collect(Collectors.toList());
        Long[] ids = new Long[sprintIds.size()];
        return userStoryProxy.getProjectUserStories(sprintIds.toArray(ids));
    }
}
