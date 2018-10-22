package nju.se4.demo.service;

import nju.se4.demo.domain.Tag;
import nju.se4.demo.util.Response;
import nju.se4.demo.vo.AthenVO;
import nju.se4.demo.vo.UserVO;


public interface UserService {
    /**
     * 根据用户id获取用户信息
     * @param id
     * @return
     */
    Response<UserVO> getUserById(int id);

    /**
     * 修改用户信息
     * @param id
     * @param nickName
     * @param avatar
     * @param bio
     * @return
     */
    Response<UserVO> updateUserInfo(int id, String nickName, String avatar, String bio);

    /**
     * 修改用户密码
     * @param id
     * @param newPassword
     * @return
     */
    Response<UserVO> updatePassword(int id, String newPassword);

    /**
     * 判断能否登录
     * @param username
     * @param password
     * @return
     */
    Response<AthenVO> canLogin(String username, String password);

    Response<Tag> addUserToGroup(String userId, String shareLink);

}
