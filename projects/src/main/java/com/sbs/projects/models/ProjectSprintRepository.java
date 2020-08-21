package com.sbs.projects.models;

import org.springframework.data.repository.CrudRepository;

public interface ProjectSprintRepository extends CrudRepository<ProjectSprint, Long> {

    Iterable<ProjectSprint> findByProjectId(Long projectId);
}
