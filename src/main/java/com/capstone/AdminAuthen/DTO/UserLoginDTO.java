package com.capstone.AdminAuthen.DTO;

public class UserLoginDTO {
    private Integer userId;
    private String email;
    private String fullName;
    private String passWord;
    private Integer roleId;

    public UserLoginDTO() {
    }

    public UserLoginDTO(Integer userId, String email, String fullName, String passWord, Integer roleId) {
        this.userId = userId;
        this.email = email;
        this.fullName = fullName;
        this.passWord = passWord;
        this.roleId = roleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserLoginDTO{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", roleId=" + roleId +
                '}';
    }
}
