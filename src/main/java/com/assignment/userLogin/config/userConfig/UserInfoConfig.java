package com.assignment.userLogin.config.userConfig;

import com.assignment.userLogin.entity.UserInfoEntity;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.Collection;

@RequiredArgsConstructor
public class UserInfoConfig implements UserDetails {
    private final UserInfoEntity userInfoEntity;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays
                .stream(userInfoEntity.getRoles()
                        .split(","))
                .map(SimpleGrantedAuthority::new)
                .toList();
    }

    @Override
    public String getPassword() {
        return userInfoEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return userInfoEntity.getEmailId();

    }
}
