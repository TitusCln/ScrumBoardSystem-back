package com.sbs.projects;

import com.sbs.contracts.dto.ProjectDTO;
import com.sbs.contracts.dto.SprintDTO;
import com.sbs.contracts.dto.SprintUserStoryDTO;
import com.sbs.contracts.dto.UserStoryDTO;
import com.sbs.projects.services.ProjectService;
import com.sbs.projects.services.SprintService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "Projects microservice")
public class ProjectControllerImpl implements ProjectController {
    private static final Logger logger = LoggerFactory.getLogger(ProjectControllerImpl.class);

    @Autowired
    private ProjectService projectService;
    @Autowired
    private SprintService sprintService;

    @GetMapping(value = "/projects", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Gets all projects created and Sprints if withSprints it's set to true")
    @Override
    public Iterable<ProjectDTO> getAllProjects(@RequestParam(name = "withSprints", defaultValue = "false") Boolean withSprints) {
        return projectService.getAll(withSprints);
    }

    @GetMapping(value = "/projects/{projectId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Gets the Project with the specified projectId")
    @Override
    public ProjectDTO getProjectById(@PathVariable Long projectId, @RequestParam(name = "withSprints", defaultValue = "false") Boolean withSprints) {
        return projectService.getById(projectId, withSprints);
    }

    @PostMapping(value = "/projects", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Creates a new Project")
    @Override
    public ProjectDTO createProject(@RequestBody ProjectDTO project) {
        return projectService.create(project);
    }

    @PutMapping(value = "/projects/{projectId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Updates the Project with the specified projectId")
    @Override
    public ProjectDTO updateProject(@PathVariable Long projectId, @RequestBody ProjectDTO project) {
        return projectService.update(projectId, project);
    }

    @DeleteMapping(value = "/projects/{projectId}")
    @ApiOperation(value = "Deletes the Project with the specified projectId")
    @Override
    public void deleteProject(@PathVariable Long projectId) {
        projectService.deleteById(projectId);
    }

    @GetMapping(value = "/projects/{projectId}/sprints", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Gets all the sprints related to a Project by the projectId attribute")
    @Override
    public Iterable<SprintDTO> getAllSprints(@PathVariable Long projectId) {
        return sprintService.getAll(projectId);
    }

    @GetMapping(value = "/projects/{projectId}/sprints/{sprintId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get the Project's sprint with the specified sprintId")
    @Override
    public SprintDTO getSprint(@PathVariable Long projectId, @PathVariable Long sprintId) {
        return sprintService.getById(projectId, sprintId);
    }

    @PostMapping(value = "/projects/{projectId}/sprints", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Creates a new Sprint related to the Project with the specified projectId")
    @Override
    public SprintDTO createSprint(@PathVariable Long projectId, @RequestBody SprintDTO sprint) {
        return sprintService.create(projectId, sprint);
    }

    @PutMapping(value = "/projects/{projectId}/sprints/{sprintId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Updates the Sprint related with the specified sprintId")
    @Override
    public SprintDTO updateSprint(@PathVariable Long projectId, @PathVariable Long sprintId, @RequestBody SprintDTO sprint) {
        return sprintService.update(projectId, sprintId, sprint);
    }

    @DeleteMapping(value = "/projects/{projectId}/sprints/{sprintId}")
    @ApiOperation(value = "Deletes the Sprint specified by the sprintId")
    @Override
    public void deleteSprint(@PathVariable Long projectId, @PathVariable Long sprintId) {
        sprintService.delete(projectId, sprintId);
    }

    @GetMapping(value = "/projects/{projectId}/userstories", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Gets the Project's User Stories related to the projectId")
    @Override
    public Iterable<UserStoryDTO> getProjectUserStories(@PathVariable Long projectId) {
        return projectService.getProjectUserStories(projectId);
    }

    @PostMapping(value = "/projects/{projectId}/userstories", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Creates a new User Story related to the Project identified by projectId and creates its relationship")
    @Override
    public UserStoryDTO createProjectUserStory(@PathVariable Long projectId, @RequestBody UserStoryDTO userStoryDTO) {
        return projectService.createProjectUserStory(projectId, userStoryDTO);
    }

    @DeleteMapping(value = "/projects/{projectId}/userstories/{userStoryId}")
    @ApiOperation(value = "Deletes the User Story identified by the userStoryId and the relation between its Project")
    @Override
    public void deleteProjectUserStory(@PathVariable Long projectId, @PathVariable Long userStoryId) {
        projectService.deleteProjectUserStory(projectId, userStoryId);
    }

    @GetMapping(value = "/projects/sprints/{userStoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get the Sprint and User Story relationship specified by the userStoryId")
    @Override
    public SprintUserStoryDTO getSprintByUserStoryId(@PathVariable Long userStoryId) {
        return projectService.getSprintUserStoryByUserStoryId(userStoryId);
    }
}
