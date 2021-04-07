package mk.finki.ukim.wpproekt.model;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public enum  Role implements GrantedAuthority {

    ROLE_USER, ROLE_ADMIN;

   @Override
    public String getAuthority() {
        return name();
    }
}