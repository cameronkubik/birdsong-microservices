package com.birdsong.application.model;

import com.birdsong.application.service.BoxOfficeService;
import com.birdsong.application.model.Movie;

public class BoxOfficeContent {

    // Service to interact with Database
    private BoxOfficeService service = new BoxOfficeService();
    
    // private members that reflect dynamic components of the UI screens
    private OperationHours opHours;
    private Admission admission;
    private Notice notice;

    /*
     * The constructor used for loading content to the website This will be called
     * for every request to the public home page
     */
    public BoxOfficeContent() {
        opHours = service.getOperationHours();
        admission = service.getAdmissionInfo();
        notice = service.getNotice();
    }

    /*
     * The constructor used by {HomeService service} to wrap content coming from the
     * database
     */
    public BoxOfficeContent(OperationHours _opHours, Admission _admission, Notice _notice) {
        opHours = _opHours;
        admission = _admission;
        notice = _notice;
    }

    /*
     * GETTERS and SETTERS for Spring framework and UI content loading
     */
    public OperationHours getOperationHours() {
        return opHours;
    }

    public Admission getAdmission() {
        return admission;
    }

    public Notice getNotice() {
        return notice;
    }

}