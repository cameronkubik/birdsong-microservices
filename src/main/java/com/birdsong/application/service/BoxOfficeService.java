package com.birdsong.application.service;

import com.birdsong.application.model.Admission;
import com.birdsong.application.model.BoxOfficeContent;
import com.birdsong.application.model.OperationHours;
import com.birdsong.application.model.Notice;

import org.springframework.stereotype.Service;

@Service
public class BoxOfficeService {

    private Db2Manager dbManager = Db2Manager.getInstance();

    public BoxOfficeContent getContent() {
        return new BoxOfficeContent(dbManager.getOperationHours(),
                dbManager.getAdmissionInfo(), dbManager.getNotice());
    }

    public OperationHours getOperationHours() {
        OperationHours operationHours = dbManager.getOperationHours();
        return operationHours;
    }

    public Admission getAdmissionInfo() {
        Admission admission = dbManager.getAdmissionInfo();
        return admission;
    }

    public Notice getNotice() {
        Notice notice = dbManager.getNotice();
        return notice;
    }

    public void post(BoxOfficeContent content) {
        // dbManager.postOperationHours(content.getOperationHours());
        // dbManager.postAdmissionHours(content.getAdmission());
        dbManager.postNotice(content.getNotice().getMainNotice(), content.getNotice().getSubNotice());
    }
}