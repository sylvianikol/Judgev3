package com.syn.judgev3.web;

import com.syn.judgev3.service.ProblemService;
import com.syn.judgev3.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

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

        //TODO: this.problemService.getAllByUserId(userId);
        //TODO: model.addAttribute("problems", problems);

        return "home";
    }
}
