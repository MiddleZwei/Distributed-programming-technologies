package com.webservlets.webservletdatabase.service;

import com.webservlets.webservletdatabase.entity.User;
import com.webservlets.webservletdatabase.model.CustomUserDetailsImpl;
import com.webservlets.webservletdatabase.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository ur;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<User> optionalUsers = ur.findByLogin(login);


        optionalUsers
                .orElseThrow(() -> new UsernameNotFoundException("Login(username) not found"));


        return optionalUsers
                .map(CustomUserDetailsImpl::new).get();

//        return optionalUsers
//                .map(user -> new CustomUserDetailsImpl(user)).get();
    }
}
