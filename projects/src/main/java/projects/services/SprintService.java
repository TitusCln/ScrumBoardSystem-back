package projects.services;

import com.sbs.dto.Sprint;

public interface SprintService {

    Iterable<Sprint> getAll(Long projectId);

    Sprint getById(Long projectId, Long sprintId);

    Sprint create(Long projectId, Sprint sprint);

    Sprint update(Long projectId, Long sprintId, Sprint sprint);

    void delete(Long projectId, Long sprintId);
}
