package nju.se4.demo.dao;

import nju.se4.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDAO extends JpaRepository<User, Integer>{
    User findUserByUsername(String username);
}
