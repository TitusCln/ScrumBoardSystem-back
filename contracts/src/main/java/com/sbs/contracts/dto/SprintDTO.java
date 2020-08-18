package com.sbs.contracts.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDate;

@JsonDeserialize(builder = SprintDTO.Builder.class)
public class SprintDTO {

    private Long id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;

    public SprintDTO() {
    }

    public SprintDTO(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public static class Builder {
        private Long id;
        private String name;
        private LocalDate startDate;
        private LocalDate endDate;

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withStartDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder withEndDate(LocalDate endDate) {
            this.endDate = endDate;
            return this;
        }

        public SprintDTO build() {
            return new SprintDTO(this);
        }
    }
}
