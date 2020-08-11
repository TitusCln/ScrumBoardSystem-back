package userStories.models;

import javax.persistence.*;

@Entity
@Table
public class UserStoryType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    public UserStoryType() {
    }

    public UserStoryType(String description) {
        this.description = description;
    }
}
