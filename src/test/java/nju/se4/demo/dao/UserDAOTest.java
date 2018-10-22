package nju.se4.demo.dao;

import nju.se4.demo.domain.User;
import nju.se4.demo.enumeration.UserIdentity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDAOTest {
    @Autowired
    private UserDAO userDAO;

    @Test
    public void update() {
        List<User> users = userDAO.findAll();
        for(User u: users) {
            if(u.getUsername().equals("67"))
            System.out.println(u.getUserIdentity());
        }
    }


}