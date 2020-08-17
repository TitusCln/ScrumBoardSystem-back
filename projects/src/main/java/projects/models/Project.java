package projects.models;

import javax.persistence.*;
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

    public Project(com.sbs.dto.Project project) {
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

    public com.sbs.dto.Project toDTO(Boolean withSprints) {
        com.sbs.dto.Project.Builder builder = new com.sbs.dto.Project.Builder()
                .withId(this.id)
                .withName(this.name);
        if (withSprints) {
            builder.withSprints(this.sprints.parallelStream()
                    .map(Sprint::toDTO)
                    .collect(Collectors.toSet()));
        }
        return builder.build();
    }

    public com.sbs.dto.Project toDTO() {
        return this.toDTO(false);
    }
}
