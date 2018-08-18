package com.tuts.prakash.retrofittutorial.model;

import com.google.gson.annotations.SerializedName;

public class PostUserRespond {

    @SerializedName("name")
    private String name;
    @SerializedName("password")
    private String password;
    @SerializedName("email")
    private String email;
    @SerializedName("contactNumber")
    private String contactNumber;
    @SerializedName("userType")
    private String userType;


    public PostUserRespond(String name, String password, String email, String contactNumber, String userType) {

        this.name = name;
        this.password = password;
        this.email = email;
        this.contactNumber = contactNumber;
        this.userType = userType;

    }


    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getcontactNumber() {
        return contactNumber;
    }

    public void setcontactNumber(String contactNumber) {
        this.contactNumber= contactNumber;
    }

    public String getuserType() {
        return userType;
    }

    public void setuserType(String price) {
        this.userType = userType;
    }

}
