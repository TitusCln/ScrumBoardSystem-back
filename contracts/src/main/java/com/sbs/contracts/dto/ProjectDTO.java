package com.sbs.contracts.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Set;

@JsonDeserialize(builder = ProjectDTO.Builder.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectDTO {

    private Long id;
    private String name;
    private Set<SprintDTO> sprintDTOS;

    public ProjectDTO() {
    }

    public ProjectDTO(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.sprintDTOS = builder.sprintDTOS;
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

    public Set<SprintDTO> getSprints() {
        return sprintDTOS;
    }

    public void setSprints(Set<SprintDTO> sprintDTOS) {
        this.sprintDTOS = sprintDTOS;
    }

    public static class Builder {
        private Long id;
        private String name;
        private Set<SprintDTO> sprintDTOS;

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withSprints(Set<SprintDTO> sprintDTOS) {
            this.sprintDTOS = sprintDTOS;
            return this;
        }

        public ProjectDTO build() {
            return new ProjectDTO(this);
        }
    }
}
