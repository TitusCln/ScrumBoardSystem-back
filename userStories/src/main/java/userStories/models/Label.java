package userStories.models;

import com.sbs.contracts.dto.LabelDTO;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Label {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String description;

    @ManyToMany
    private Set<UserStory> userStories;

    public Label() {
    }

    public Label(LabelDTO label) {
        this.id = label.getId();
        this.description = label.getDescription();
    }

    public Label(String description) {
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

    public Set<UserStory> getUserStories() {
        return userStories;
    }

    public void setUserStories(Set<UserStory> userStories) {
        this.userStories = userStories;
    }
}
