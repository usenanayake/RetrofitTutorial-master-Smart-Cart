package com.tuts.prakash.retrofittutorial.model;

import com.google.gson.annotations.SerializedName;

public class PostDeleteRespond {

    @SerializedName("sucess")
    private String sucess;
    @SerializedName("message")
    private String message;


    public PostDeleteRespond(String sucess, String message) {

        this.sucess = sucess;
        this.message = message;

    }

    public String getSucess() {
        return sucess;
    }

    public void setSucess(String sucess) {
        this.sucess = sucess;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
