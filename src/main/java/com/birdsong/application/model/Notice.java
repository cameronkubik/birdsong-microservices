package com.birdsong.application.model;

public class Notice {

    private String mainNotice;
    private String subNotice;

    public Notice(String _mainNotice, String _subNotice) {
        this.mainNotice = _mainNotice;
        this.subNotice = _subNotice;
    }

    public String getMainNotice() {
        return this.mainNotice;
    }

    public String getSubNotice() {
        return this.subNotice;
    }
}