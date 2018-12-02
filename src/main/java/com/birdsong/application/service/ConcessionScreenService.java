package com.birdsong.application.service;

import com.birdsong.application.model.SaleItem;
import com.birdsong.application.service.Db2Manager;
import java.util.ArrayList;

import org.springframework.stereotype.Service;


@Service
public class ConcessionScreenService {
    
    private ArrayList<SaleItem> saleItemsList;
    Db2Manager dbManager = new Db2Manager();
 
    static {
        //System.out.print("Any static logic can be executed here...");
    }

    public ConcessionScreenService() {
        this.saleItemsList = new ArrayList<SaleItem>();
    }

    public ArrayList<SaleItem> getSaleItemsList() {
        this.saleItemsList = dbManager.getConcessionList();
        // make call to DB
        // ...logic...
        // assign to saleItemsList

        return this.saleItemsList;
    }
}