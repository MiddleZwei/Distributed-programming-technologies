package com.webservlets.webservletdatabase.entity;

import javax.persistence.*;

@Entity
@Table(name = "users", catalog = "test")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String login;
    private String passsword;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasssword() {
        return passsword;
    }

    public void setPasssword(String passsword) {
        this.passsword = passsword;
    }

    public User(){}

    public User(String login, String passsword) {
        this.login = login;
        this.passsword = passsword;
    }
}
