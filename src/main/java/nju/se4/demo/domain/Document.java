package nju.se4.demo.domain;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * 文档的分享链接
     */
    private String shareLink;

    /**
     * 文档名称
     */
    private String name;

    /**
     * 文档的编写用户
     */
    @ElementCollection
    @JsonProperty("owners")
    private List<User> userList;

    /**
     * 文档的创建时间
     */
    @JsonProperty("createdAt")
    private String createTime;

    /**
     * 文档的更新时间
     */
    @JsonProperty("updatedAt")
    private String updateTime;

    public Document() {
    }

    public Document(String shareLink, String name,
                    List<User> userList, String createTime, String updateTime) {
        this.shareLink = shareLink;
        this.name = name;
        this.userList = userList;
        this.createTime = createTime;
        this.updateTime = updateTime;
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
