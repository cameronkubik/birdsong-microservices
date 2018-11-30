package microservice;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonGetter;

public class AboutUsScreenContent {

    Db2Manager dbManager;
    ArrayList<String> aboutUsInfo;
    
    public AboutUsScreenContent(Db2Manager _dbManager) {
        dbManager = _dbManager;
        aboutUsInfo = dbManager.getAboutUsInfo();
    }

    @JsonGetter("aboutUs")
    public ArrayList<String> getAboutUsInfo() {
        return aboutUsInfo;
    }
}