package microservice;

import java.util.ArrayList;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.json.*;

@RestController
public class HomeScreenController {

    @Autowired
    HomeScreenService service;

    @RequestMapping("/")
    public String loadHomeScreen(ModelMap model, @RequestParam String name) {
        model.put("name", name);
        return "homeScreen";
    }
}