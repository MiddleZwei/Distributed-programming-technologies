package com.webservlets.webservletdatabase.model;

import com.webservlets.webservletdatabase.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class CustomUserDetailsImpl extends User implements UserDetails {

    public CustomUserDetailsImpl(final User user) {
        super(user);

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRole()))
                .collect(Collectors.toList());

//        Set<GrantedAuthority> set = new HashSet<>();
//        switch (role){ //yes, without break;
//            case ADMIN: set.add(Role.ADMIN.getGrantedAuthority());
//            case MODERATOR: set.add(Role.MODERATOR.getGrantedAuthority());
//            case USER: set.add(Role.USER.getGrantedAuthority());
//        }
//        return set;

    }

    @Override
    public String getPassword() {
        return super.getPasssword();
    }

    @Override
    public String getUsername() {
        return super.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
