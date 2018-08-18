package com.tuts.prakash.retrofittutorial.model;

import com.google.gson.annotations.SerializedName;

public class PostCartRequest {

    @SerializedName("refId")
    private String refId;
    @SerializedName("user")
    private String user;

    public PostCartRequest(String refId, String user) {

        this.refId = refId;
        this.user = user;

    }


    public String getrefId() {
        return refId;
    }

    public void setrefId(String refId) {
        this.refId = refId;
    }

    public String getuser() {
        return user;
    }

    public void setuser(String user) {
        this.user = user;
    }
}
