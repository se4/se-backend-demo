package nju.se4.demo.service.Impl;

import nju.se4.demo.dao.UserDAO;
import nju.se4.demo.domain.User;
import nju.se4.demo.service.UserService;
import nju.se4.demo.util.Converter;
import nju.se4.demo.util.Response;
import nju.se4.demo.util.innerData.Abilities;
import nju.se4.demo.vo.AthenVO;
import nju.se4.demo.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    private Converter convertor = new Converter();

    @Override
    public Response<UserVO> getUserById(int id) {
        try {
            User user = userDAO.getOne(id);
            UserVO userVO = convertor.convertToUserVO(user);
            Abilities abilities = new Abilities();
            abilities.setUpdate(true);
            return new Response<>(abilities, userVO);

        }catch (Exception ex) {
            ex.printStackTrace();
            Abilities abilities = new Abilities();
            abilities.setUpdate(false);
            return new Response<>(abilities, new UserVO());
        }
    }

    @Override
    public Response<UserVO> updateUserInfo(int id, String nickName, String avatar, String bio) {
        try {
            User user = userDAO.getOne(id);
            user.setNickName(nickName);
            user.setAvatar(avatar);
            user.setBio(bio);
            Abilities abilities = new Abilities();
            abilities.setUpdate(true);
            UserVO userVO = convertor.convertToUserVO(user);
            return new Response<>(abilities, userVO);
        }catch (Exception ex){
            ex.printStackTrace();
            Abilities abilities = new Abilities();
            abilities.setUpdate(false);
            return new Response<>(abilities, new UserVO());
        }
    }

    @Override
    public Response<UserVO> updatePassword(int id, String newPassword) {
        try {
            User user = userDAO.getOne(id);
            user.setPassword(newPassword);
            UserVO userVO = convertor.convertToUserVO(user);
            Abilities abilities = new Abilities();
            abilities.setUpdate(true);
            return new Response<>(abilities, userVO);
        }catch (Exception ex){
            ex.printStackTrace();
            Abilities abilities = new Abilities();
            abilities.setUpdate(false);
            return new Response<>(abilities, new UserVO());
        }
    }

    @Override
    public Response<AthenVO> canLogin(String username, String password) {
        try {
            List<User> list = userDAO.findAll();
            String pw = "";
            User user = new User();
            for (User u : list) {
                if (u.getUsername().equals(username) ) {
                    pw = u.getPassword();
                    user = u;
                }
            }
            Abilities abilities = new Abilities();
            if ( pw.equals(password)) {
                abilities.setUpdate(true);
            } else {
                abilities.setUpdate(false);
            }
            Converter convertor = new Converter();
            UserVO userVO = convertor.convertToUserVO(user);
            AthenVO athenVO = new AthenVO();
            athenVO.setToken(username);
            athenVO.setUser(userVO);
            return new Response<>(abilities, athenVO);
        }catch (Exception ex) {
            ex.printStackTrace();
            Abilities abilities = new Abilities();
            abilities.setUpdate(false);
            return new Response<>(abilities, new AthenVO());
        }
    }
}
