package com.syn.judgev3.service.impl;

import com.syn.judgev3.model.binding.SubmissionCreateBindingModel;
import com.syn.judgev3.model.entity.Problem;
import com.syn.judgev3.model.entity.Submission;
import com.syn.judgev3.model.entity.User;
import com.syn.judgev3.model.service.SubmissionServiceModel;
import com.syn.judgev3.repository.SubmissionRepository;
import com.syn.judgev3.service.ProblemService;
import com.syn.judgev3.service.SubmissionService;
import com.syn.judgev3.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class SubmissionServiceImpl implements SubmissionService {

    private final SubmissionRepository submissionRepository;
    private final ProblemService problemService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public SubmissionServiceImpl(SubmissionRepository submissionRepository, ProblemService problemService, UserService userService, ModelMapper modelMapper) {
        this.submissionRepository = submissionRepository;
        this.problemService = problemService;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @Override
    public SubmissionServiceModel create(SubmissionCreateBindingModel submissionCreateBindingModel,
                                         String problemId, String userId) {
        try {
            Submission submission = this.modelMapper.map(submissionCreateBindingModel, Submission.class);
            Problem problem = this.modelMapper.map(this.problemService.getById(problemId), Problem.class);
            User user = this.modelMapper.map(this.userService.getById(userId), User.class);

            submission.setAchievedResult(this.getRandomValue(problem.getPoints()));
            submission.setCreatedOn(LocalDateTime.now());
            List<Submission> submissions = problem.getSubmissions();
            if (submissions == null) {
                submissions = List.of(submission);
            } else {
                submissions.add(submission);
            }

            problem.setSubmissions(submissions);

            submission.setProblem(problem);
            submission.setUser(user);

            this.submissionRepository.save(submission);

            return this.modelMapper.map(submission, SubmissionServiceModel.class);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }

    private int getRandomValue(int bound) {
        Random random = new Random();
        return random.nextInt(bound);
    }
}
