package userStories.models;

import javax.persistence.*;
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
    @ManyToMany
    @JoinTable(
            name = "story_label",
            joinColumns = @JoinColumn(name = "userStory_id"),
            inverseJoinColumns = @JoinColumn(name = "label_id"))
    private Set<Label> labels;

    public UserStory(dto.UserStory userStory){
        this.id=userStory.getId();
        this.title= userStory.getTitle();
        this.description= userStory.getDescription();
        this.weight= userStory.getWeight();
        this.labels=userStory.getLabels().parallelStream().map(Label::new).collect(Collectors.toSet());
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

    public dto.UserStory toDTO(){
        return new dto.UserStory.Builder()
                .withId(this.id)
                .withTitle(this.title)
                .withDescription(this.description)
                .withWeight(this.weight)
                .withLabels(this.labels.parallelStream().map(label -> new dto.Label.Builder()
                        .withId(label.getId())
                        .withDescription(label.getDescription())
                        .build()).collect(Collectors.toSet()))
                .build();
    }
}
