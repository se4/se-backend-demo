package nju.se4.demo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import nju.se4.demo.enumeration.UserIdentity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * 用户身份的枚举类型
     */
    @JsonProperty("role")
    private UserIdentity userIdentity;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    @JsonProperty("nickname")
    private String nickName;

    /**
     * 用户自我描述
     */
    private String bio;

    /**
     * 用户头像url
     */
    private String avatar;

    /**
     * 账户创建时间
     */
    @JsonProperty("createAt")
    private String createTime;

    /**
     * 账户更新时间
     */
    @JsonProperty("updateAt")
    private String updateTime;

    public User() {
    }

    public User(UserIdentity userIdentity, String username,
                String password, String nickName, String bio,
                String avatar, String createTime, String updateTime) {
        this.userIdentity = userIdentity;
        this.username = username;
        this.password = password;
        this.nickName = nickName;
        this.bio = bio;
        this.avatar = avatar;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserIdentity getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(UserIdentity userIdentity) {
        this.userIdentity = userIdentity;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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
