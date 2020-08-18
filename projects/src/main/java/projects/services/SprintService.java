package projects.services;

import com.sbs.contracts.dto.SprintDTO;

public interface SprintService {

    Iterable<SprintDTO> getAll(Long projectId);

    SprintDTO getById(Long projectId, Long sprintId);

    SprintDTO create(Long projectId, SprintDTO SprintDTO);

    SprintDTO update(Long projectId, Long sprintId, SprintDTO SprintDTO);

    void delete(Long projectId, Long sprintId);
}
