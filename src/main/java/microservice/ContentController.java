package microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContentController {

    @Autowired
    private Db2Manager dbManager = new Db2Manager();

    @RequestMapping("/content/get-home-screen")
    public HomeScreenContent getHomeScreenContent() {
        dbManager.initializeConnection();

        HomeScreenContent homeScreen = new HomeScreenContent(dbManager);
        // get now showing movies
        // getWelcomeText
        // get special event accouncements
        // bundle together
        return homeScreen;
    }

    @RequestMapping("/content/get-box-office-screen")
    public BoxOfficeScreenContent getBoxOfficeScreenContent() {
        return new BoxOfficeScreenContent("", (long) 1, "", "", "", "", 0);
    }

    @RequestMapping("/content/get-concession-screen")
    public ConcessionScreenContent getConcessionScreenContent() {
        return new ConcessionScreenContent("", (long) 1, "", "", "", "", 0);
    }

    @RequestMapping("/content/get-about-us-screen")
    public AboutUsScreenContent getAboutUsScreenContent() {
        return new AboutUsScreenContent("", (long) 1, "", "", "", "", 0);
    }

    @RequestMapping("/content/get-footer-screen")
    public FooterContent getFooterContent() {
        return new FooterContent("", (long) 1, "", "", "", "", 0);
    }
}