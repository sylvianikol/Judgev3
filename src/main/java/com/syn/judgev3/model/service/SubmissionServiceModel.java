package com.syn.judgev3.model.service;

import java.time.LocalDateTime;
import java.util.List;

public class SubmissionServiceModel extends BaseServiceModel {

    private List<String> code;
    private int achievedResult;
    private LocalDateTime createdOn;
    private ProblemServiceModel problem;
    private UserServiceModel user;

    public SubmissionServiceModel() {
    }

    public List<String> getCode() {
        return code;
    }

    public void setCode(List<String> code) {
        this.code = code;
    }

    public int getAchievedResult() {
        return achievedResult;
    }

    public void setAchievedResult(int achievedResult) {
        this.achievedResult = achievedResult;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public ProblemServiceModel getProblem() {
        return problem;
    }

    public void setProblem(ProblemServiceModel problem) {
        this.problem = problem;
    }

    public UserServiceModel getUser() {
        return user;
    }

    public void setUser(UserServiceModel user) {
        this.user = user;
    }
}
