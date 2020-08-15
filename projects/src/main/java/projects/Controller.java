package projects;

import com.sbs.dto.Project;
import com.sbs.dto.Sprint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import projects.services.ProjectService;
import projects.services.SprintService;

@RestController
public class Controller {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private SprintService sprintService;

    @GetMapping(value = "/projects", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Project> getAllProjects() {
        return projectService.getAll();
    }

    @GetMapping(value = "/projects/{projectId}")
    public Project getProjectById(@PathVariable Long projectId) {
        return projectService.getById(projectId);
    }

    @PostMapping(value = "/projects")
    public Project createProject(@RequestBody Project project) {
        return projectService.create(project);
    }

    @PutMapping(value = "/projects/{projectId}")
    public Project updateProject(@PathVariable Long projectId, @RequestBody Project project) {
        return projectService.update(projectId, project);
    }

    @DeleteMapping(value = "/projects/{projectId}")
    public void deleteProject(@PathVariable Long projectId) {
        projectService.deleteById(projectId);
    }

    @GetMapping(value = "/projects/{projectId}/sprints")
    public Iterable<Sprint> getAllSprints(@PathVariable Long projectId) {
        return sprintService.getAll();
    }

    @GetMapping(value = "/projects/{projectId}/sprints/{sprintId}")
    public Sprint getSprint(@PathVariable Long projectId, @PathVariable Long sprintId) {
        return sprintService.getById(projectId, sprintId);
    }

    @PostMapping(value = "/projects/{projectId}/sprints")
    public Sprint createSprint(@PathVariable Long projectId, @RequestBody Sprint sprint) {
        return sprintService.create(projectId, sprint);
    }

    @PutMapping(value = "/projects/{projectId}/sprints/{sprintId}")
    public Sprint updateSprint(@PathVariable Long projectId, @PathVariable Long sprintId, @RequestBody Sprint sprint) {
        return sprintService.update(projectId, sprintId, sprint);
    }

    @DeleteMapping(value = "/projects/{projectId}/sprints/{sprintId}")
    public void deleteSprint(@PathVariable Long projectId, @PathVariable Long sprintId) {
        sprintService.delete(projectId, sprintId);
    }
}
