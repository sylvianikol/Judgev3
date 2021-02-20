package com.syn.judgev3.service.impl;

import com.syn.judgev3.repository.ProblemRepository;
import com.syn.judgev3.service.ProblemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProblemServiceImpl implements ProblemService {

    private final ProblemRepository problemRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProblemServiceImpl(ProblemRepository problemRepository, ModelMapper modelMapper) {
        this.problemRepository = problemRepository;
        this.modelMapper = modelMapper;
    }
}
