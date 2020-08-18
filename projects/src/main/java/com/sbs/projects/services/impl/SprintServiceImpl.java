package com.sbs.projects.services.impl;

import com.sbs.contracts.dto.SprintDTO;
import com.sbs.projects.models.SprintRepository;
import com.sbs.projects.services.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SprintServiceImpl implements SprintService {

    @Autowired
    private SprintRepository sprintRepository;

    @Override
    public Iterable<SprintDTO> getAll(Long projectId) {
        return StreamSupport.stream(sprintRepository.findByProjectId(projectId).spliterator(), true)
                .map(com.sbs.projects.models.Sprint::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SprintDTO getById(Long projectId, Long sprintId) {
        return sprintRepository.findById(sprintId).get().toDTO();
    }

    @Override
    public SprintDTO create(Long projectId, SprintDTO sprint) {
        com.sbs.projects.models.Sprint sprintToCreate = new com.sbs.projects.models.Sprint(sprint);
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
