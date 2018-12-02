package com.birdsong.application.model;

public class WelcomeMessage {

    private String header;
    private String subHeader;

    public WelcomeMessage(String _header, String _subHeader) {
        this.header = _header;
        this.subHeader = _subHeader;
    }

    public String getHeader() {
        return this.header;
    }

    public String getSubHeader() {
        return this.subHeader;
    }
}