package com.syn.judgev3.service;

import com.syn.judgev3.model.binding.SubmissionCreateBindingModel;
import com.syn.judgev3.model.service.SubmissionServiceModel;

public interface SubmissionService {
    SubmissionServiceModel create(SubmissionCreateBindingModel submissionCreateBindingModel, String problemId, String userId);
}
