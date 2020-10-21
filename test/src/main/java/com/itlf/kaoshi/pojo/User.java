package com.itlf.kaoshi.pojo;

/**
 * @Author LiuFeng
 * @Date 2020/10/10 20:34
 */

public class User {
    private String username;
    private String password;

    public User(String user, String password) {
        this.username = user;
        this.password = password;
    }

    public String getUser() {
        return username;
    }

    public void setUser(String user) {
        this.username = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
