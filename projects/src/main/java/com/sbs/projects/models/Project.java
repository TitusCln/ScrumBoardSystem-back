package com.sbs.projects.models;

import com.sbs.contracts.dto.ProjectDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "project")
    private Set<Sprint> sprints;

    public Project() {
    }

    public Project(ProjectDTO project) {
        this.id = project.getId();
        this.name = project.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Transforms the Project Entity into a new ProjectDTO Object
     *
     * @param withSprints the specified flag to returns the Sprints relationship object
     * @return the ProjectDTO Objects corresponded to the Project entity
     */
    public ProjectDTO toDTO(Boolean withSprints) {
        ProjectDTO.Builder builder = new ProjectDTO.Builder()
                .withId(this.id)
                .withName(this.name);
        if (withSprints) {
            builder.withSprints(this.sprints.parallelStream()
                    .map(Sprint::toDTO)
                    .collect(Collectors.toSet()));
        }
        return builder.build();
    }

    /**
     * Transforms the Project Entity into a new ProjectDTO Object
     *
     * @return the ProjectDTO Objects corresponded to the Project entity
     */
    public ProjectDTO toDTO() {
        return this.toDTO(false);
    }
}
