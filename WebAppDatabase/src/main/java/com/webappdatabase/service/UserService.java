package com.webappdatabase.service;


import com.webappdatabase.model.User;

/**
 * Service class for {@link User}
 *
 * @author Illia Halych
 * @version 1.0
 */

public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
