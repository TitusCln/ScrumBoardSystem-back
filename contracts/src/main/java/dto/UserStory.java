package dto;

import java.util.Set;

public class UserStory {

    private Long id;
    private String title;
    private String description;
    private int weight;
    private Set<Label> labels;

    public UserStory(Builder builder) {
        this.id= builder.id;
        this.title= builder.title;
        this.description= builder.description;
        this.weight= builder.weight;
        this.labels=builder.labels;
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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Set<Label> getLabels() {
        return labels;
    }

    public void setLabels(Set<Label> labels) {
        this.labels = labels;
    }

    public static class Builder{
        private Long id;
        private String title;
        private String description;
        private Integer weight;
        private Set<Label> labels;

        public Builder withId(Long id){
            this.id=id;
            return this;
        }

        public Builder withTitle(String title){
            this.title=title;
            return this;
        }

        public Builder withDescription(String description){
            this.description=description;
            return this;
        }

        public Builder withWeight(Integer weight){
            this.weight=weight;
            return this;
        }

        public Builder withLabels(Set<Label> labels){
            this.labels=labels;
            return this;
        }

        public UserStory build(){ return new UserStory(this);}
    }
}

