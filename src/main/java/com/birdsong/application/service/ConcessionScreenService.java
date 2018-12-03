package com.birdsong.application.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

import com.birdsong.application.model.*;

// Service for Model
@Service
public class ConcessionScreenService {
    
    private ArrayList<SaleItem> saleItemsList;
    private Db2Manager dbManager = Db2Manager.getInstance();
 
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

    public boolean postSaleItemsList()  {
        return false;
    }
}