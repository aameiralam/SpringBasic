package com.springInitializer.DemoSpring.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.mapping.Value;

@Entity
public class Demon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull(message = "Fill this out")
    @Size(min=3, max=75, message = "Name has to be between 3 - 75 characters long")
    private String name;
    @NotNull(message = "Fill this out")
    @Min(value=1, message = "Demons cannot be shorter than 1 feet")
    @Max(value = 20, message = "Demons cannot be longer than 20 feet")
    private Double height;
    @NotNull(message = "Fill this out")
    @Min(value = 5, message = "No demons should weigh less than 5lbs")
    @Max(value = 2000, message = "No demons should weigh more than 2000lbs")
    private Double weight;
    @NotNull(message = "Fill this out")
    @Size(min = 25, max = 300, message = "Describe within 25 - 300 characters")
    private String description;


public Demon() {
}

    public Demon(Double weight, String name, Double height, String description) {
        this.weight = weight;
        this.name = name;
        this.height = height;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
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

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}


