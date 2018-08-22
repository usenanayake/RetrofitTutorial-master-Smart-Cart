package com.tuts.prakash.retrofittutorial.model;

import com.google.gson.annotations.SerializedName;

public class PostLoginRespond {




    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;
    @SerializedName("success")
    private String success;
    @SerializedName("userType")
    private String userType;

    public PostLoginRespond(String username, String password, String success,String userType) {
        this.username = username;
        this.password = password;
        this.success = success;
        this.userType = userType;
    }

    public String getusername() {
        return username;
    }

    public void setusername(String username) { this.username = username;  }

    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    public String getsuccess() {
        return success;
    }

    public void setsuccess(String success) {
        this.success = success;
    }

    public String getuserType() {
        return userType;
    }

    public void setuserType(String success) {
        this.userType = userType;
    }

}
