package nju.se4.demo.service;

import nju.se4.demo.domain.Tag;
import nju.se4.demo.util.Response;

import java.util.List;

public interface TagService {
    /**
     * 增加标签
     * @param id
     * @param type
     * @param name
     * @return
     */
    Response<Tag> addTag(int id, String type, String name);

    /**
     * 查找userId的用户的所有标签
     * @param userId
     * @return
     */
    Response<List<Tag>> getTagListByUserId(String userId);


}
