package com.syn.judgev3.model.binding;

import javax.validation.constraints.NotBlank;

public class SubmissionCreateBindingModel {

    private String code;

    public SubmissionCreateBindingModel() {
    }

    @NotBlank(message = "Code can not be null or empty")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
