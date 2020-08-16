package userStories.models;

import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {

    Iterable<Task> findByUserStoryId(Long userStoryId);
}
