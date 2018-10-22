package nju.se4.demo.controller;

import nju.se4.demo.security.SecurityUser;
import nju.se4.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.security.RolesAllowed;

import static nju.se4.demo.security.WebSecurityConstants.TEACHER_ROLE;
import static nju.se4.demo.security.WebSecurityConstants.STUDENT_ROLE;

@Controller
@RequestMapping("/api/v1/authorization/")
public class AuthDemoController {
    private final UserService userService;

    @Autowired
    public AuthDemoController(UserService userService) {
        this.userService = userService;
    }

    @RolesAllowed({TEACHER_ROLE})
    @RequestMapping(value = "test/teacher", method = RequestMethod.GET)
    @ResponseBody
    public Object teacher( SecurityUser userDetails) {
        return userDetails;
    }

    @RolesAllowed({STUDENT_ROLE})
    @RequestMapping(value = "test/student", method = RequestMethod.GET)
    @ResponseBody
    public Object student(@AuthenticationPrincipal String username) {
        return username;
    };

    @RequestMapping(value = "test/noauth", method = RequestMethod.GET)
    @ResponseBody
    public Object noAuth() {
        return null;
    };

    @RolesAllowed({})
    @RequestMapping(value = "test/anyauth", method = RequestMethod.GET)
    @ResponseBody
    public Object anyAuth(@AuthenticationPrincipal String username) {
        return username;
    };
}
