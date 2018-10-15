package nju.se4.demo.controller;

import nju.se4.demo.domain.Tag;
import nju.se4.demo.service.TagService;
import nju.se4.demo.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api/vX/tag/")
public class TagController {
    @Autowired
    private TagService tagService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Response<Tag> addTag(String id, String type, String name) {
        return tagService.addTag(id, type, name);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public Response<List<Tag>> getTagListByUserId(String userId) {
        return tagService.getTagListByUserId(userId);
    }
}
