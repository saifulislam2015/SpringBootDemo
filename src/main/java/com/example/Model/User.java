package com.example.Model;

import javax.persistence.*;

@Entity
@Table(name = "USERINFO")
@SequenceGenerator(name = "CRD_ID",
        sequenceName = "RTDS_ADSINPUTSEQ",
        initialValue = 543, allocationSize = 1)

public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "CRD_ID")
    @Column(name = "userid",nullable = false, unique = true)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "firstname", nullable = false)
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "lastname", nullable = false)
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public User(String f, String l, String e, String p) {
        this.firstName = f;
        this.lastName = l;
        this.email = e;
        this.password = p;
    }

    public User(){}

}
