package com.george.user.model;

import javax.persistence.*;

@Entity
public class Contact {

    @Id
//    @GeneratedValue //(strategy = GenerationType.TABLE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private  String phoneNumber;
    @Column(unique = true)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    //name is this table id, ref is user table id
//    @JoinColumn(name = "id", referencedColumnName = "id")
    // creates new column
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Contact() {
    }

//    public UserContact(Integer id, String phoneNumber, User user) {
//        this.id = id;
//        this.phoneNumber = phoneNumber;
//        this.user = user;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // end
}
