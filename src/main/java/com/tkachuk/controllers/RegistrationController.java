package com.tkachuk.controllers;

import com.tkachuk.entities.UserEntity;
import com.tkachuk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String getRegistrationPage(Model model) {
        UserEntity user = new UserEntity();
        model.addAttribute("newUser", user);
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUser(@ModelAttribute("newUser") @Valid UserEntity user, BindingResult result,
                               HttpServletRequest request, Model model) {
        if (result.hasErrors()) {
            return "registration";
        }
        UserEntity existingUser = userService.findByLogin(user.getLogin());
        if (existingUser != null) {
            model.addAttribute("loginError", true);
            return "registration";
        }
        HttpSession session = request.getSession();
        {
            userService.save(user);
            session.setAttribute("currentUser", user);
            return "redirect:/home";
        }
    }
}
