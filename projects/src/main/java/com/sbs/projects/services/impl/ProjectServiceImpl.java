package com.sbs.projects.services.impl;

import com.sbs.contracts.dto.ProjectDTO;
import com.sbs.projects.models.ProjectRespository;
import com.sbs.projects.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRespository projectRespository;

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
}
