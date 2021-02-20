package com.syn.judgev3.model.binding;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserLoginBindingModel {

    private String username;

    private String password;

    public UserLoginBindingModel() {
    }

    @NotBlank(message = "Username can not be null or empty")
    @Size(min = 3, max = 20, message = "Username length must be between 3 and 20 characters")
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotBlank(message = "Password can not be null or empty")
    @Size(min = 3, max = 20, message = "Password length must be between 3 and 20 characters ")
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
