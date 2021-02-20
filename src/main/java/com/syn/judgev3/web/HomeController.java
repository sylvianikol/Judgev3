package com.syn.judgev3.web;

import com.syn.judgev3.model.service.UserServiceModel;
import com.syn.judgev3.model.view.ProblemViewModel;
import com.syn.judgev3.service.ProblemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    private final ProblemService problemService;
    private final ModelMapper modelMapper;

    @Autowired
    public HomeController(ProblemService problemService, ModelMapper modelMapper) {
        this.problemService = problemService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    public String index(HttpSession httpSession) {
        if (httpSession.getAttribute("user") != null) {
            return "redirect:home";
        }

        return "index";
    }

    @GetMapping("/home")
    public String home(HttpSession httpSession, Model model) {

        if (httpSession.getAttribute("user") == null) {
            return "redirect:/users/login";
        }

        List<ProblemViewModel> problems = this.problemService.getAll().stream()
                .map(p -> this.modelMapper.map(p, ProblemViewModel.class))
                .collect(Collectors.toUnmodifiableList());

        int completed = 0; // todo: calculate completed %

        model.addAttribute("problems", problems);
        model.addAttribute("completed", completed);

        return "home";
    }
}
