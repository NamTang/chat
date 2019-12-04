package com.example.chat.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.chat.entity.User;
import com.example.service.UserService;
import com.example.validator.NewUserValidator;

@Controller
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @Autowired
    private NewUserValidator newUserValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(newUserValidator);
    }

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @GetMapping("/new-account")
    public String newAccount(Model model) {
        model.addAttribute("user", new User());
        return "new-account";
    }

    @PostMapping(path = "/new-account")
    public String createAccount(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new-account";
        }
        userService.createUser(user);
        return "redirect:/";
    }
}
