package nju.se4.demo.controller;

import nju.se4.demo.domain.Tag;
import nju.se4.demo.service.UserService;
import nju.se4.demo.util.Response;
import nju.se4.demo.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
@RequestMapping(value = "/api/v1/user/")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "{userId}", method = RequestMethod.GET)
    @ResponseBody
    public Response<UserVO> getUserById(@PathVariable("userId") int id) {
        return userService.getUserById(id);
    }

    @RequestMapping(value = "{userId}", method = RequestMethod.POST)
    @ResponseBody
    public Response<UserVO> updateUserInfo( @PathVariable("userId") int id,
                                           String nickname, String avatar, String bio) {
        return userService.updateUserInfo(id, nickname, avatar, bio);
    }

    @RequestMapping(value = "{userId}/password", method = RequestMethod.POST)
    @ResponseBody
    public Response<UserVO> updatePassword(@PathVariable("userId") int id,
                                           String password) {
        return userService.updatePassword(id, password);
    }


    @RequestMapping(value = "{userId}/tag", method = RequestMethod.POST)
    @ResponseBody
    public Response<Tag> addUserToGroup(@PathVariable String userId, @RequestBody HashMap<String, String> requestBody) {
        String shareLink = requestBody.get("shareLink");
        return userService.addUserToGroup(userId, shareLink);

    }


}
