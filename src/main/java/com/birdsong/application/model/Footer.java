package com.birdsong.application.model;


public class Footer {

    private String address;
    private String address2;
    private String city;
    private String state;
    private String zip;

    private String email;
    private String phone;
    private String twitter;
    private String facebook;
    private String instagram;
    private String youtube;

    public Footer() {
        // TODO - make these calls to the database to retrieve them
        this.address = "907 Shiloh Church Road";
        this.address2 = "";
        this.city = "Camden";
        this.state = "TN";
        this.zip = "38320";

        this.email = "birdsong@drive-in.com";
        this.phone = "251-442-8472";
        this.twitter = "";
        this.instagram = "";
        this.youtube = "";
    }

    public String getAddress() {
        return this.address;
    }

    public String getAddress2() {
        return this.address2;
    }

    public String getCity() {
        return this.city;
    }

    public String getState() {
        return this.state;
    }

    public String getZip() {
        return this.zip;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getTwitter() {
        return this.twitter;
    }

    public String getFacebook() {
        return this.address;
    }

    public String getInstagram() {
        return this.instagram;
    }

    public String getYoutube() {
        return this.youtube;
    }
    
    public void setAddress(String _address) {
        this.address = _address;
    }

    public void setAddress2(String _a2) {
        this.address2 = _a2;
    }

    public void setCity(String _c) {
        this.city = _c;
    }

    public void setState(String _s) {
        this.state = _s;
    }

    public void setZip(String _z) {
        this.zip = _z;
    }

    public void setEmail(String _e) {
        this.email = _e;
    }

    public void setPhone(String _p) {
        this.phone = _p;
    }

    public void setTwitter(String _t) {
        this.twitter = _t;
    }

    public void setFacebookString(String _f) {
        this.facebook = _f;
    }

    public void setInstagram(String _i) {
        this.instagram = _i;
    }

    public void setYoutube(String _y) {
        this.youtube = _y;
    }
}