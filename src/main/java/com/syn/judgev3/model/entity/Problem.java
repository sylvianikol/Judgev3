package com.syn.judgev3.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "problems")
public class Problem extends BaseEntity {

    private String name;
    private int points;

    private List<Submission> submissions;

    public Problem() {
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @OneToMany(fetch = FetchType.EAGER)
    public List<Submission> getSubmissions() {
        return submissions;
    }

    public void setSubmissions(List<Submission> submissions) {
        this.submissions = submissions;
    }
}
