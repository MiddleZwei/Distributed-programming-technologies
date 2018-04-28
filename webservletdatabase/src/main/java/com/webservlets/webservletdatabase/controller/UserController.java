package com.webservlets.webservletdatabase.controller;

import com.webservlets.webservletdatabase.entity.request.AddUserRequest;
import com.webservlets.webservletdatabase.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.webservlets.webservletdatabase.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/users") // test/hello in tutorial
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addUser(@RequestBody AddUserRequest addUserRequest){
        User user = new User();
        user.setLogin(addUserRequest.getLogin());
        user.setPasssword(addUserRequest.getPassword());
        userRepository.save(user);
    }

    @GetMapping("/all")
    public String hello(){
        return "Hi there";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/secured/all")
    public String securedHello(){
        return "Secured Hello";
    }
}
