package nju.se4.demo.service.Impl;

import nju.se4.demo.dao.TagDAO;
import nju.se4.demo.dao.UserDAO;
import nju.se4.demo.domain.Tag;
import nju.se4.demo.domain.User;
import nju.se4.demo.enumeration.TagType;
import nju.se4.demo.service.TagService;
import nju.se4.demo.util.DateHelper;
import nju.se4.demo.util.LinkUtil;
import nju.se4.demo.util.Response;
import nju.se4.demo.util.innerData.Abilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.util.resources.cldr.ga.TimeZoneNames_ga;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TagServiceImpl implements TagService {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private TagDAO tagDAO;

    @Override
    public Response<Tag> addTag(String id, String type, String name) {
        try {
            int userId = Integer.parseInt(id);
            User user = userDAO.getOne(userId);
            List<User> list = new ArrayList<>();
            list.add(user);
            Tag tag = new Tag(TagType.valueOf(type), LinkUtil.getShareLink(), name, list,
                    DateHelper.getDate());
            Abilities abilities = new Abilities();
            abilities.setUpdate(true);
            return new Response<>(abilities, tag);
        }catch (Exception ex){
            ex.printStackTrace();
            Abilities abilities = new Abilities();
            abilities.setUpdate(false);
            return new Response<>(abilities, new Tag());
        }
    }

    @Override
    public Response<List<Tag>> getTagListByUserId(String userId) {
        try {
            List<Tag> list = tagDAO.findAll();
            List<Tag> resList = new ArrayList<>();
            int id = Integer.parseInt(userId);
            User user = userDAO.getOne(id);
            for (Tag t : list) {
                if ( t.getUserList().contains(user) ) {
                    resList.add(t);
                }
            }
            Abilities abilities = new Abilities();
            abilities.setUpdate(true);
            return new Response<>(abilities, resList);
        }catch (Exception ex) {
            ex.printStackTrace();
            Abilities abilities = new Abilities();
            abilities.setUpdate(false);
            List<Tag> list = new ArrayList<>();
            return new Response<>(abilities, list);
        }
    }
}
