package com.george.user.repository;

import com.george.user.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository <Contact, Integer> {

//    String getPhoneNumberByUserId(int userId);
    default String getPhoneNumberByUserId(int userId){
       List<Contact> contact = findAll();
        for (Contact user: contact) {
            int num = user.getUser().getId();
            if( num == userId){
                return user.getPhoneNumber().toString();
            }
        }
        return null;
    }

}
