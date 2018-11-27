package microservice;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarketingController {

    private static ArrayList<UpcomingMovie> upcomingMovies = new ArrayList();

    @RequestMapping("/marketing/load-upcoming")
    public ArrayList<UpcomingMovie> loadUpcomingMovies(@RequestParam(value="theaterID", defaultValue="-1") String theaterID,
                                                @RequestParam(value="limit", defaultValue="100") String limit) {
        upcomingMovies.add(new UpcomingMovie(theaterID, limit));

        return upcomingMovies;
    }
}