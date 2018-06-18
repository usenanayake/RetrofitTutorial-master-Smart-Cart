package com.tuts.prakash.retrofittutorial.model;

import com.google.gson.annotations.SerializedName;


public class PostDetailsRequest{


    @SerializedName("name")
    private String name;
    @SerializedName("price")
    private String price;

//    @SerializedName("thumbnailUrl")
//    private String thumbnailUrl;

    public PostDetailsRequest(String name, String price) {

        this.name = name;
        this.price = price;

//        this.thumbnailUrl = thumbnailUrl;
    }


    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getprice() {
        return price;
    }

    public void setprice(String price) {
        this.price = price;
    }





//    public String getThumbnailUrl() {
//        return thumbnailUrl;
//    }
//
//    public void setThumbnailUrl(String thumbnailUrl) {
//        this.thumbnailUrl = thumbnailUrl;
//    }
}
