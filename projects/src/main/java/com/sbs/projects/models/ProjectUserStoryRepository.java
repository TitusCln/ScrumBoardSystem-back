package com.sbs.projects.models;

import org.springframework.data.repository.CrudRepository;

public interface ProjectUserStoryRepository extends CrudRepository<ProjectUserStory, Long> {

    Iterable<ProjectUserStory> findByProjectId(Long projectId);
}
