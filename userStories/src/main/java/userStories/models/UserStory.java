package userStories.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class UserStory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Integer weight;
    @ManyToMany
    @JoinTable(
            name = "story_label",
            joinColumns = @JoinColumn(name = "userStory_id"),
            inverseJoinColumns = @JoinColumn(name = "label_id"))
    private Set<Label> labels;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Set<Label> getLabels() {
        return labels;
    }

    public void setLabels(Set<Label> labels) {
        this.labels = labels;
    }

    public dto.UserStory toDTO(){
        return new dto.UserStory.Builder()
                .withId(this.id)
                .withTitle(this.title)
                .withDescription(this.description)
                .withWeight(this.weight)
                .build();
    }
}
