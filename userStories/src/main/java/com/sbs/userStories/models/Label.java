package com.sbs.userStories.models;

import com.sbs.contracts.dto.LabelDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Label {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String description;

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

    /**
     * Transforms the Label Entity to the LabelDT Object
     *
     * @return the DTO Label Object
     */
    public static LabelDTO toDTO(Label label) {
        return new LabelDTO.Builder()
                .withId(label.getId())
                .withDescription(label.getDescription())
                .build();
    }

}
