package com.syn.judgev3.model.binding;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class SubmissionCreateBindingModel {

    private List<String> code;

    public SubmissionCreateBindingModel() {
    }

    @NotBlank(message = "Code can not be empty")
    public List<String> getCode() {
        return code;
    }

    public void setCode(List<String> code) {
        this.code = code;
    }
}
