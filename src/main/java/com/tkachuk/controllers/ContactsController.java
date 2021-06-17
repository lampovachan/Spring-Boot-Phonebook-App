package com.tkachuk.controllers;

import com.tkachuk.entities.ContactsEntity;
import com.tkachuk.entities.UserEntity;
import com.tkachuk.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class ContactsController {
    @Autowired
    private ContactsService contactDao;

    @GetMapping("/add-contact")
    public String getCreateContactPage(Model model) {
        ContactsEntity contactsEntity = new ContactsEntity();
        model.addAttribute("newContact", contactsEntity);
        model.addAttribute("adding", true);
        return "addContact";
    }

    @PostMapping("/add-contact")
    public String addNewContact(@ModelAttribute("newContact") @Valid ContactsEntity contact, BindingResult result,
                                HttpServletRequest request, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("adding", true);
            return "addContact";
        }
        HttpSession session = request.getSession();
        UserEntity user = (UserEntity) session.getAttribute("currentUser");
        if (contact != null) {
            contact.setUserId(user);
            contactDao.createContact(contact);
        }
        return "redirect:/home";
    }

    @GetMapping("/delete")
    public String editContact(@RequestParam("contactId") Integer contactId) {
        if (contactId != null) {
            contactDao.deleteContact(contactDao.findContactById(contactId));
        }
        return "redirect:/home";
    }

    @GetMapping("/edit")
    public String getEditContactPage(@RequestParam("contactId") Integer contactId, Model model) {
        model.addAttribute("newContact", contactDao.findContactById(contactId));
        model.addAttribute("editing", true);
        return "addContact";
    }

    @PostMapping("/edit")
    public String editContact(@ModelAttribute("newContact") @Valid ContactsEntity contact, BindingResult result,
                              HttpServletRequest request, Model model) {
        if (result.hasErrors()){
            model.addAttribute("editing", true);
            return "addContact";
        }

        HttpSession session = request.getSession();
        UserEntity user = (UserEntity) session.getAttribute("currentUser");
        if (contact != null) {
            contact.setUserId(user);
            contactDao.editContact(contact);
        }
        return "redirect:/home";
    }
}
