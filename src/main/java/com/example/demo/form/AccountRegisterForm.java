package com.example.demo.form;



import java.util.Date;

public class AccountRegisterForm {

    private String loginId;
    private String password;
    private String nickname;
    //private Gender gender;
    private Date birthday;
    private Date registeredAt;
    private Date withdrewAt;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /*public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }*/

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(Date registeredAt) {
        this.registeredAt = registeredAt;
    }

    public Date getWithdrewAt() {
        return withdrewAt;
    }

    public void setWithdrewAt(Date withdrewAt) {
        this.withdrewAt = withdrewAt;
    }

}
