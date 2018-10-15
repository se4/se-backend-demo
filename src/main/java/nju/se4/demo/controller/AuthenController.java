package nju.se4.demo.controller;

import nju.se4.demo.service.UserService;
import nju.se4.demo.util.Response;
import nju.se4.demo.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/v1/authorization/")
public class AuthenController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public Response<UserVO> login(String username, String password) {
        return userService.canLogin(username, password);
    }
}
