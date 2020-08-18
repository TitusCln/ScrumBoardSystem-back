package com.sbs.contracts.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = LabelDTO.Builder.class)
public class LabelDTO {

    private Long id;
    private String description;

    public LabelDTO() {
    }

    public LabelDTO(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public LabelDTO(Builder builder) {
        this.id= builder.id;
        this.description= builder.description;
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

    public static class Builder{

        private Long id;
        private String description;

        public Builder withId(Long id){
            this.id=id;
            return this;
        }

        public Builder withDescription(String description){
            this.description=description;
            return this;
        }

        public LabelDTO build(){ return new LabelDTO(this);}
    }
}
