package userStories.models;

import javax.persistence.*;

@Entity
@Table
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Double duration;
    @ManyToOne
    @JoinColumn(name = "userstory_id")
    private UserStory userStory;

    public Task() {
    }

    public Task(com.sbs.dto.Task task) {
        this.id = task.getId();
        this.description = task.getDescription();
        this.duration = task.getDuration();
    }


    public Task(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public UserStory getUserStory() {
        return userStory;
    }

    public void setUserStory(UserStory userStory) {
        this.userStory = userStory;
    }

    public com.sbs.dto.Task toDTO() {
        return new com.sbs.dto.Task.Builder()
                .withId(this.id)
                .withDescription(this.description)
                .withDuration(this.duration)
                .build();
    }
}
