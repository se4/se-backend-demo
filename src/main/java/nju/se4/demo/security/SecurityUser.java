package nju.se4.demo.security;

import static nju.se4.demo.security.WebSecurityConstants.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import nju.se4.demo.domain.User;
import nju.se4.demo.security.exception.NotFoundException;
import nju.se4.demo.security.others.Entity;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.*;


@javax.persistence.Entity
@Table(name = "securityuser")
@ToString
public class SecurityUser extends Entity<SecurityUser> implements UserDetails {
    @Id
    @Column(name = "username")
    @JsonProperty(value = "username")
    private String username;

    @Column(name = "password")
    @JsonProperty(value = "password")
    private String password;

    @Column(name = "authorities")
    private ArrayList<GrantedAuthority> authorities;

    public SecurityUser(SecurityUser user){
        this.username = user.username;
        this.password = user.password;

        this.authorities = new ArrayList<>(user.authorities);
    }
    public SecurityUser(){
    }
    public SecurityUser(User user) {
        password = user.getPassword();
        username = user.getUsername();
        BeanUtils.copyProperties(user, this);
        this.authorities = new ArrayList<>();
        switch (user.getUserIdentity()) {
            case STUDENT:
                this.authorities.add(STUDENT_AUTHORITY);
                break;
            case TEACHER:
                this.authorities.add(TEACHER_AUTHORITY);
                break;
            default:
                throw new NotFoundException(user.getUsername());
        }
    }

    @Override
    public String getPrimeKey() {
        return username;
    }

    @Override
    public SecurityUser copy() {
        return new SecurityUser(this);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAuthorities(ArrayList<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUsername() {
        return username;
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