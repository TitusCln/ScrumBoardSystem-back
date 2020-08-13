package userStories.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table
public class UserStory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Integer weight;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "story_label",
            joinColumns = @JoinColumn(name = "userStory_id"),
            inverseJoinColumns = @JoinColumn(name = "label_id"))
    private Set<Label> labels;

    public UserStory() {
    }

    public UserStory(com.sbs.dto.UserStory userStory) {
        this.id = userStory.getId();
        this.title = userStory.getTitle();
        this.description = userStory.getDescription();
        this.weight = userStory.getWeight();
        this.labels = Optional.ofNullable(userStory.getLabels()).stream()
                .flatMap(Collection::parallelStream)
                .map(Label::new).collect(Collectors.toSet());

    }

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

    public com.sbs.dto.UserStory toDTO() {
        return new com.sbs.dto.UserStory.Builder()
                .withId(this.id)
                .withTitle(this.title)
                .withDescription(this.description)
                .withWeight(this.weight)
                .withLabels(this.labels.parallelStream().map(label -> new com.sbs.dto.Label.Builder()
                        .withId(label.getId())
                        .withDescription(label.getDescription())
                        .build()).collect(Collectors.toSet()))
                .build();
    }
}
