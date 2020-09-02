package com.sbs.userStories.models;

import com.sbs.contracts.dto.LabelDTO;
import com.sbs.contracts.dto.TaskDTO;
import com.sbs.contracts.dto.UserStoryDTO;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table
public class UserStory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Integer weight;
  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinTable(
          name = "story_label",
          joinColumns = @JoinColumn(name = "userStory_id"),
          inverseJoinColumns = @JoinColumn(name = "label_id"))
  private Set<Label> labels;

  @OneToMany(mappedBy = "userStory", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private Set<Task> tasks;

  public UserStory() {
  }

  public UserStory(UserStoryDTO userStory) {
    this.id = userStory.getId();
    this.title = userStory.getTitle();
    this.description = userStory.getDescription();
    this.weight = userStory.getWeight();
    this.tasks = Optional.ofNullable(userStory.getTasks())
            .orElse(new HashSet<>())
            .parallelStream()
            .map(Task::new)
            .map(task -> task.withUserStory(this))
            .collect(Collectors.toSet());
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public Set<Task> getTasks() {
    return tasks;
  }

  public void setTasks(Set<Task> tasks) {
    this.tasks = tasks;
  }

  public UserStoryDTO toDTO() {
    return new UserStoryDTO.Builder()
        .withId(this.id)
        .withTitle(this.title)
        .withDescription(this.description)
        .withWeight(this.weight)
        .withLabels(this.labels.parallelStream().map(label -> new LabelDTO.Builder()
            .withId(label.getId())
            .withDescription(label.getDescription())
            .build()).collect(Collectors.toSet()))
        .withTasks(this.tasks.parallelStream().map(task -> new TaskDTO.Builder()
            .withId(task.getId())
            .withDescription(task.getDescription())
            .withDuration(task.getDuration())
//                .withUserStory(Optional.ofNullable(task.getUserStory()).orElse(new UserStory()).toDTO())
            .build()).collect(Collectors.toSet()))
        .build();
  }
}
