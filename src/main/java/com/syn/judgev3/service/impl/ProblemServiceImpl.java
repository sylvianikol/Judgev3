package com.syn.judgev3.service.impl;

import com.syn.judgev3.model.entity.Problem;
import com.syn.judgev3.model.service.ProblemServiceModel;
import com.syn.judgev3.repository.ProblemRepository;
import com.syn.judgev3.service.ProblemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProblemServiceImpl implements ProblemService {

    private final ProblemRepository problemRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProblemServiceImpl(ProblemRepository problemRepository, ModelMapper modelMapper) {
        this.problemRepository = problemRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean create(ProblemServiceModel problemServiceModel) {
        Problem problem = this.modelMapper.map(problemServiceModel, Problem.class);

        try {
            this.problemRepository.save(problem);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public List<ProblemServiceModel> getAll() {
        return this.problemRepository.findAll().stream()
                .map(t -> this.modelMapper.map(t, ProblemServiceModel.class))
                .collect(Collectors.toUnmodifiableList());
    }
}
