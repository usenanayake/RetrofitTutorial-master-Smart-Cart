package com.tuts.prakash.retrofittutorial.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by praka on 12/24/2017.
 */

public class RetroPhoto {

    @SerializedName("_id")
    private String _id;
    @SerializedName("name")
    private String name;
    @SerializedName("price")
    private String price;
    @SerializedName("__v")
    private Integer __v;
//    @SerializedName("thumbnailUrl")
//    private String thumbnailUrl;

    public RetroPhoto(Integer albumId, Integer id, String title, String url, String thumbnailUrl) {
        this._id = _id;
        this.name = name;
        this.price = price;
        this.__v = __v;
//        this.thumbnailUrl = thumbnailUrl;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String albumId) {
        this._id = _id;
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

    public Integer get__v() {
        return __v;
    }

    public void set__v(Integer __v) {
        this.__v = __v;
    }

//    public String getThumbnailUrl() {
//        return thumbnailUrl;
//    }
//
//    public void setThumbnailUrl(String thumbnailUrl) {
//        this.thumbnailUrl = thumbnailUrl;
//    }
}
