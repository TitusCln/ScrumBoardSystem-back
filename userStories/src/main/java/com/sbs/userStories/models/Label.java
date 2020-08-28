package com.sbs.userStories.models;

import com.sbs.contracts.dto.LabelDTO;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table
public class Label {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String description;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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

    public static LabelDTO toDTO(Label label) {
        return new LabelDTO.Builder()
                .withId(label.getId())
                .withDescription(label.getDescription())
                .build();
    }

    public Label addUserStory(UserStory userStory) {
        if (!Objects.nonNull(this.userStories))
            this.userStories = new HashSet<>();
        this.userStories.add(userStory);
        return this;
    }
}
