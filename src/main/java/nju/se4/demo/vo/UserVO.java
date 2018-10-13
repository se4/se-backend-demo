package nju.se4.demo.vo;

import nju.se4.demo.enumeration.UserIdentity;

public class UserVO {
    private String id;

    /**
     * 用户身份的枚举类型
     */
    private String userIdentity;

    /**
     * 用户名
     */
    private String username;

    /**
     * 昵称
     */
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
    private String createTime;

    /**
     * 账户更新时间
     */
    private String updateTime;

    public UserVO() {
    }

    public UserVO(String userIdentity, String username,
                String nickName, String bio,
                String avatar, String createTime, String updateTime) {
        this.userIdentity = userIdentity;
        this.username = username;
        this.nickName = nickName;
        this.bio = bio;
        this.avatar = avatar;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(String userIdentity) {
        this.userIdentity = userIdentity;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
