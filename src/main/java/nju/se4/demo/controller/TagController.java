package nju.se4.demo.controller;

import nju.se4.demo.dao.UserDAO;
import nju.se4.demo.domain.Tag;
import nju.se4.demo.domain.User;
import nju.se4.demo.enumeration.UserIdentity;
import nju.se4.demo.service.TagService;
import nju.se4.demo.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;

import static nju.se4.demo.security.WebSecurityConstants.STUDENT_ROLE;
import static nju.se4.demo.security.WebSecurityConstants.TEACHER_ROLE;

@Controller
@RequestMapping("/api/v1/")
public class TagController {
    @Autowired
    private TagService tagService;
    @Autowired
    private UserDAO userDAO;

    @RolesAllowed({TEACHER_ROLE,STUDENT_ROLE})
    @RequestMapping(value = "tag", method = RequestMethod.POST)
    @ResponseBody
    public Response<Tag> addTag(@AuthenticationPrincipal String username , @RequestBody HashMap<String, String> requestBody) {
        String name = requestBody.get("name");
        String type = requestBody.get("type");
        User userByUsername = userDAO.findUserByUsername(username);
        return tagService.addTag(userByUsername.getId(), type, name);
    }

    @RequestMapping(value = "tag", method = RequestMethod.GET)
    @ResponseBody
    public Response<List<Tag>> getTagListByUserId(@RequestParam("userId") String userId) {
        return tagService.getTagListByUserId(userId);
    }


}
