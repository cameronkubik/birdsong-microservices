package microservice;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonGetter;

public class ConcessionScreenContent {                   

    Db2Manager dbManager;
    ArrayList<ConcessionItem> concessionList;

    public ConcessionScreenContent(Db2Manager _dbManager) {
        dbManager = _dbManager;
        concessionList = dbManager.getConcessionList();
    }
}