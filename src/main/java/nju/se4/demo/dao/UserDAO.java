package nju.se4.demo.dao;

import nju.se4.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Integer>{

}
