package com.webappdatabase.service;

/**
 * Service for Security.
 *
 * @author Illia Halych
 * @version 1.0
 */

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
