package kr.co.ares.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CustomUserDetails extends User {

    public CustomUserDetails(String username, String password, Collection authorities) {
        super(username, password, authorities);
    }
}
