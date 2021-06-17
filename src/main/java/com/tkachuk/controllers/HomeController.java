package com.tkachuk.controllers;

import com.tkachuk.entities.UserEntity;
import com.tkachuk.service.ContactsService;
import com.tkachuk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private ContactsService contactDao;

    @RequestMapping("/")
    public String index(HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserEntity user = (UserEntity) session.getAttribute("currentUser");
        if (user != null)
            return "redirect:/home";
        return "index";
    }

    @GetMapping("/home")
    public String getHomePage(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserEntity user = (UserEntity) session.getAttribute("currentUser");
        if (user == null)
            return "redirect:/";
        else {
            model.addAttribute("contacts", contactDao.getUserContacts(user));
        }
        return "home";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam(value = "login") String login, @RequestParam("password") String password,
                            HttpServletRequest request, Model model) {
        String page = null;
        HttpSession session = request.getSession();
        UserEntity user = userService.findByLoginAndPassword(login, password);
        if (user != null) {
            session.setAttribute("currentUser", user);
            page = "redirect:/home";
        } else {
            model.addAttribute("loginError", true);
            model.addAttribute("loginValue", login);
            page = "index";
        }
        return page;
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/";
    }
}
