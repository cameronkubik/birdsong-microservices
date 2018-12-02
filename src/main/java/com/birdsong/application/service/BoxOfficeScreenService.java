package com.birdsong.application.service;

import com.birdsong.application.model.Admission;
import com.birdsong.application.model.OperationHours;
import com.birdsong.application.model.Notice;

import org.springframework.stereotype.Service;

@Service
public class BoxOfficeScreenService {

    private Db2Manager dbManager = Db2Manager.getInstance();

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
}