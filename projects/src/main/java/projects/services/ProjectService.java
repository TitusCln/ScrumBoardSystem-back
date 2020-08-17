package projects.services;


import com.sbs.dto.Project;

public interface ProjectService {

    Iterable<Project> getAll(Boolean withSprints);

    Project getById(Long id, Boolean withSprints);

    Project create(Project project);

    Project update(Long id, Project project);

    void deleteById(Long id);
}
