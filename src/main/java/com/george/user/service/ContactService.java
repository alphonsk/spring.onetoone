package com.george.user.service;

import com.george.user.model.Contact;
import com.george.user.model.User;
import com.george.user.repository.ContactRepository;
import com.george.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private UserRepository userRepository;


    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public String createUserContact(Integer id, Contact contact) {
        Optional<User> user = userRepository.findById(id);
        User myuser = user.get();
        Contact contact1 = new Contact();
        contact1.setPhoneNumber(contact.getPhoneNumber());
        contact1.setUser(myuser);
        contactRepository.save(contact1);
        return contact.getPhoneNumber();
    }

    public String getPhoneNumberByUserId(Integer id) {
        return contactRepository.getPhoneNumberByUserId(id);
    }


    // end
}
