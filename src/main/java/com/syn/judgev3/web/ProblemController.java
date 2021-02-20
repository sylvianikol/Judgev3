package com.syn.judgev3.web;

import com.syn.judgev3.model.binding.ProblemCreateBindingModel;
import com.syn.judgev3.model.service.ProblemServiceModel;
import com.syn.judgev3.service.ProblemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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

    @PostMapping("/create")
    public String createConfirm(@Valid ProblemCreateBindingModel problemCreateBindingModel,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("problemCreateBindingModel", problemCreateBindingModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.problemCreateBindingModel",
                    bindingResult);

            return "redirect:create";
        }

        boolean isCreated = this.problemService.create(
                this.modelMapper.map(problemCreateBindingModel, ProblemServiceModel.class));

        if (!isCreated) {
            redirectAttributes.addFlashAttribute("problemCreateBindingModel", problemCreateBindingModel);
            redirectAttributes.addFlashAttribute("exists", true);

            return "redirect:create";
        }

        return "redirect:/";
    }

    @GetMapping("/submit/{id}")
    public String submit(@PathVariable String id, HttpSession httpSession, Model model) {

        if (httpSession.getAttribute("user") == null) {
            return "redirect:/users/login";
        }

//        ProblemServiceModel problemServiceModel = this.problemService.getById(id);
        return "create-submission";
    }
}
