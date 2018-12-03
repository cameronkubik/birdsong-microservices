package com.birdsong.application.model;

import com.birdsong.application.service.AboutUsScreenService;;

public class HomeContent {

    private AboutUsScreenService service = new AboutUsScreenService();

    private String welcome;
    private String specialEvents;

    public HomeContent() {
        this.welcome = service.getHeaderFromDb();
        this.specialEvents = service.getSubHeaderFromDb();
    }

    public HomeContent(String _welcome, String _specialEvents) {
        this.welcome = _welcome;
        this.specialEvents = _specialEvents;
    }

    public String getwelcome() {
        return this.welcome;
    }

    public void setwelcome(String _welcome) {
        this.welcome = _welcome;
    }

    public String getspecialEvents() {
        return this.specialEvents;
    }

    public void setspecialEvents(String _specialEvents) {
        this.specialEvents = _specialEvents;
    }
}