package com.birdsong.application.model;

public class AboutUsContent {

    private String header;
    private String subHeader;
    private String body;

    public AboutUsContent(String _header, String _subHeader, String _body) {
        this.header = _header;
        this.subHeader = _subHeader;
        this.body = _body;
    }

    public String getHeader() {
        return this.header;
    }

    public String getSubHeader() {
        return this.subHeader;
    }
    public String getBody() {
        return this.body;
    }
}