package nju.se4.demo.util;

import nju.se4.demo.domain.User;
import nju.se4.demo.vo.UserVO;

public class Convertor {
    public UserVO convertToUserVO(User user) {
        UserVO userVO = new UserVO();
        userVO.setId(user.getId() + "");
        userVO.setUsername(user.getUsername());
        userVO.setUserIdentity(user.getUserIdentity().toString());
        userVO.setNickName(user.getNickName());
        userVO.setAvatar(user.getAvatar());
        userVO.setBio(user.getBio());
        userVO.setCreateTime(user.getCreateTime());
        userVO.setUpdateTime(user.getUpdateTime());
        return userVO;
    }
}
