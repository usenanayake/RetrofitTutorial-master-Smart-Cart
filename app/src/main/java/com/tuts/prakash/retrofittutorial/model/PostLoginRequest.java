package com.tuts.prakash.retrofittutorial.model;

import com.google.gson.annotations.SerializedName;

public class PostLoginRequest {

    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;

    public PostLoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
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
}
