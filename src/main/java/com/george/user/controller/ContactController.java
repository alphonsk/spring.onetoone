package com.george.user.controller;

import com.george.user.model.Contact;
import com.george.user.repository.ContactRepository;
import com.george.user.service.ContactService;
import com.george.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {

    @Autowired
    private ContactService contactService;
    @Autowired
    private UserService userService;
    @Autowired
    private ContactRepository contactRepository;

    @GetMapping("/usercontacts")
    public List<Contact> getAllContacts(){
        return contactService.getAllContacts();
    }


    // add user contact
    @PostMapping("/user/{id}/usercontact")
    public String createUserContact(@PathVariable Integer id, @RequestBody Contact contact){
        return contactService.createUserContact(id, contact);
    }

    // get user contact
    @GetMapping("/user/{id}/usercontact")
    public String getUserContact(@PathVariable Integer id){
        return contactService.getPhoneNumberByUserId(id);
    }




}
