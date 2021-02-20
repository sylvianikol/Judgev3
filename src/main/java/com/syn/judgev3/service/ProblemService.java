package com.syn.judgev3.service;

import com.syn.judgev3.model.service.ProblemServiceModel;

import java.util.Collection;
import java.util.List;

public interface ProblemService {

    boolean create(ProblemServiceModel problemServiceModel);

    List<ProblemServiceModel> getAll();

    ProblemServiceModel getById(String id);
}
