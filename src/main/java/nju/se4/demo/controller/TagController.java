package nju.se4.demo.controller;

import nju.se4.demo.domain.Tag;
import nju.se4.demo.enumeration.UserIdentity;
import nju.se4.demo.service.TagService;
import nju.se4.demo.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.websocket.server.PathParam;
import java.util.List;

@Controller
@RequestMapping("/api/v1/")
public class TagController {
    @Autowired
    private TagService tagService;

    @RolesAllowed({"TEACHER"})
    @RequestMapping(value = "tag", method = RequestMethod.POST)
    @ResponseBody
    public Response<Tag> addTag(@AuthenticationPrincipal String id, String type, String name) {
        return tagService.addTag(id, type, name);
    }

    @RequestMapping(value = "tag", method = RequestMethod.GET)
    @ResponseBody
    public Response<List<Tag>> getTagListByUserId(@RequestParam("userId") String userId) {
        return tagService.getTagListByUserId(userId);
    }
}
