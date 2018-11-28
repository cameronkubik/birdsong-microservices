package microservice;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@RestController
public class ContentController {
    @Value("${db2.privateKey}")
    String privateKey;
    
    @RequestMapping("/content/get-home-screen")
    public HomeScreenContent getHomeScreen() {
        return new HomeScreenContent();
    }
}