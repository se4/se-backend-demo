package nju.se4.demo.vo;

import nju.se4.demo.domain.User;

public class AthenVO {
    private UserVO user;

    private String token;

    public AthenVO() {
    }

    public AthenVO(UserVO user, String token) {
        this.user = user;
        this.token = token;
    }

    public UserVO getUser() {
        return user;
    }

    public void setUser(UserVO user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
