package com.tkachuk.controllers;

import com.tkachuk.entities.ContactsEntity;
import com.tkachuk.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactsController {
    @Autowired
    private ContactsService contactService;

    @GetMapping("/add-contact")
    public String getCreateContactPage(Model model) {
        ContactsEntity contactsEntity = new ContactsEntity();
        model.addAttribute("newContact", contactsEntity);
        model.addAttribute("adding", true);
        return "addContact";
    }


}
