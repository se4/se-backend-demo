package nju.se4.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import nju.se4.demo.enumeration.TagType;
import nju.se4.demo.util.DateHelper;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class Tag implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private int id;

    /**
     * 标签类型
     */
    @JsonProperty("type")
    private TagType tagType;

    /**
     * 分享链接
     */
    private String shareLink;

    /**
     * 标签名
     */
    private String name;

    /**
     * 用户列表
     */
    @ElementCollection
    @JsonProperty("owners")
    private List<User> userList;

    /**
     * 标签创建时间
     */
    @JsonProperty("createdAt")
    private String createTime;

    /**
     * 标签更新时间
     */
    @JsonProperty("updatedAt")
    private String updateTime;

    public Tag() {
    }

    public Tag(TagType tagType, String shareLink, String name,
               List<User> userList, String updateTime) {
        this.tagType = tagType;
        this.shareLink = shareLink;
        this.name = name;
        this.userList = userList;
        this.createTime = DateHelper.getDate();
        this.updateTime = updateTime;
    }

    public TagType getTagType() {
        return tagType;
    }

    public void setTagType(TagType tagType) {
        this.tagType = tagType;
    }

    public String getShareLink() {
        return shareLink;
    }

    public void setShareLink(String shareLink) {
        this.shareLink = shareLink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
