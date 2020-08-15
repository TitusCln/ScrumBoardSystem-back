package projects.services;


import com.sbs.dto.Project;

public interface ProjectService {

    Iterable<Project> getAll();

    Project getById(Long id);

    Project create(Project project);

    Project update(Long id, Project project);

    void deleteById(Long id);
}
