package com.birdsong.application.model;

import com.birdsong.application.service.AboutUsScreenService;;

public class AboutUsContent {

    private AboutUsScreenService service = new AboutUsScreenService();

    private String header;
    private String subHeader;
    private String body;

    public AboutUsContent() {
        this.header = service.getHeaderFromDb();
        this.subHeader = service.getBodyFromDb();
        this.body = service.getBodyFromDb();
        // this.subHeader = _subHeader;
        // this.body = _body;
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