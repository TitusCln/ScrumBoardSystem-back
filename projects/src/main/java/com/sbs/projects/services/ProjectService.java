package com.sbs.projects.services;

import com.sbs.contracts.dto.ProjectDTO;

public interface ProjectService {

    Iterable<ProjectDTO> getAll(Boolean withSprints);

    ProjectDTO getById(Long id, Boolean withSprints);

    ProjectDTO create(ProjectDTO ProjectDTO);

    ProjectDTO update(Long id, ProjectDTO ProjectDTO);

    void deleteById(Long id);
}
