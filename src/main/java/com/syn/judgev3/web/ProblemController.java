package com.syn.judgev3.web;

import com.syn.judgev3.model.binding.ProblemCreateBindingModel;
import com.syn.judgev3.service.ProblemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/problems")
public class ProblemController {

    private final ProblemService problemService;
    private final ModelMapper modelMapper;

    @Autowired
    public ProblemController(ProblemService problemService, ModelMapper modelMapper) {
        this.problemService = problemService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/create")
    public String create(HttpSession httpSession, Model model) {

        if (httpSession.getAttribute("user") == null) {
            return "redirect:/users/login";
        }

        if (!model.containsAttribute("problemCreateBindingModel")) {
            model.addAttribute("problemCreateBindingModel", new ProblemCreateBindingModel());
            model.addAttribute("exists", false);
        }

        return "create-problem";
    }
}
