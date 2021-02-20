package com.syn.judgev3.model.binding;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProblemCreateBindingModel {

    private String name;
    private int points;

    public ProblemCreateBindingModel() {
    }

    @NotBlank(message = "Problem name can not be null or empty")
    @Size(min = 3, max = 50, message = "Problem name length must be between 3 and 50 characters")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull(message = "Total points can not be null")
    @Min(value = 0, message = "Problem total points can not be a negative number")
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
