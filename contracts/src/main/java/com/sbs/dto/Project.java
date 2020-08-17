package com.sbs.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Set;

@JsonDeserialize(builder = Project.Builder.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Project {

    private Long id;
    private String name;
    private Set<Sprint> sprints;

    public Project() {
    }

    public Project(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.sprints = builder.sprints;
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

    public Set<Sprint> getSprints() {
        return sprints;
    }

    public void setSprints(Set<Sprint> sprints) {
        this.sprints = sprints;
    }

    public static class Builder {
        private Long id;
        private String name;
        private Set<Sprint> sprints;

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withSprints(Set<Sprint> sprints) {
            this.sprints = sprints;
            return this;
        }

        public Project build() {
            return new Project(this);
        }
    }
}
