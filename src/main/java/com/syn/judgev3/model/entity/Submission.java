package com.syn.judgev3.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "submissions")
public class Submission extends BaseEntity {

    private String code;
    private int achievedResult;
    private LocalDateTime createdOn;
    private Problem problem;
    private User user;

    public Submission() {
    }

    @Column(nullable = false, columnDefinition = "TEXT")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "achieved_result", nullable = false)
    public int getAchievedResult() {
        return achievedResult;
    }

    public void setAchievedResult(int achievedResult) {
        this.achievedResult = achievedResult;
    }

    @Column(name = "created_on", nullable = false)
    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
