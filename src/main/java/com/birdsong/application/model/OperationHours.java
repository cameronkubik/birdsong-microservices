package com.birdsong.application.model;


public class OperationHours {

    private int openTime;
    private int showingsStartTime;

    public OperationHours(int _openTime, int _showingsStartTime) {
        this.openTime = _openTime;
        this.showingsStartTime = _showingsStartTime;
    }

    public int getOpenTime() {
        return openTime;
    }

    public int getShowingsStartTime() {
        return showingsStartTime;
    }
}