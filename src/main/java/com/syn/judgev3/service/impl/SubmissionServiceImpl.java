package com.syn.judgev3.service.impl;

import com.syn.judgev3.repository.SubmissionRepository;
import com.syn.judgev3.service.SubmissionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubmissionServiceImpl implements SubmissionService {

    private final SubmissionRepository submissionRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public SubmissionServiceImpl(SubmissionRepository submissionRepository, ModelMapper modelMapper) {
        this.submissionRepository = submissionRepository;
        this.modelMapper = modelMapper;
    }
}
