package projects.services.impl;

import com.sbs.contracts.dto.SprintDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projects.models.SprintRepository;
import projects.services.SprintService;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SprintServiceImpl implements SprintService {

    @Autowired
    private SprintRepository sprintRepository;

    @Override
    public Iterable<SprintDTO> getAll(Long projectId) {
        return StreamSupport.stream(sprintRepository.findByProjectId(projectId).spliterator(), true)
                .map(projects.models.Sprint::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SprintDTO getById(Long projectId, Long sprintId) {
        return sprintRepository.findById(sprintId).get().toDTO();
    }

    @Override
    public SprintDTO create(Long projectId, SprintDTO sprint) {
        projects.models.Sprint sprintToCreate = new projects.models.Sprint(sprint);
        sprintToCreate.setIsolatedProject(projectId);
        return sprintRepository.save(sprintToCreate).toDTO();
    }

    @Override
    public SprintDTO update(Long projectId, Long sprintId, SprintDTO newSprint) {
        return sprintRepository.findById(sprintId)
                .map(sprint -> {
                    sprint.setName(newSprint.getName());
                    sprint.setStartDate(newSprint.getStartDate());
                    sprint.setEndDate(newSprint.getEndDate());
                    return sprintRepository.save(sprint).toDTO();
                }).get();
    }

    @Override
    public void delete(Long projectId, Long sprintId) {
        sprintRepository.deleteById(sprintId);
    }
}
