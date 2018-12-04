package com.birdsong.application.model;

import com.birdsong.application.service.AboutUsScreenService;

public class AboutUsContent {

    private AboutUsScreenService service = new AboutUsScreenService();

    private String header;
    private String subHeader;
    private String body;

    public AboutUsContent() {
        //repeated queries
        this.header = service.getAboutUs().getHeader();
        this.subHeader = service.getAboutUs().getSubHeader();
        this.body = service.getAboutUs().getBody();
    }

    public AboutUsContent(String _header, String _subHeader, String _body) {
        this.header = _header;
        this.subHeader = _subHeader;
        this.body = _body;
    }

    public String getHeader() {
        return this.header;
    }

    public void setHeader(String _header) {
        this.header = _header;
    }

    public String getSubHeader() {
        return this.subHeader;
    }

    public void setSubHeader(String _subheader) {
        this.subHeader  = _subheader;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String _body) {
        this.body = _body;
    }
}