package nju.se4.demo.controller;

import nju.se4.demo.service.UserService;
import nju.se4.demo.util.Response;
import nju.se4.demo.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/api/vX/user/")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public Response<UserVO> getUserById(@PathVariable("userId") int id) {
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.POST)
    @ResponseBody
    public Response<UserVO> updateUserInfo(@PathVariable("userId") int id,
                                           String nickname, String avatar, String bio) {
        return userService.updateUserInfo(id, nickname, avatar, bio);
    }

    @RequestMapping(value = "/{userId}/password", method = RequestMethod.POST)
    @ResponseBody
    public Response<UserVO> updatePassword(@PathVariable("userId") int id,
                                           String password) {
        return userService.updatePassword(id, password);
    }

}
