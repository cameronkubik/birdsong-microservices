package microservice;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
// import microservice.otherPackage

// Service for Model
@Service
public class HomeScreenService {

    static {
        System.out.print("Home Screen initialized!");
    }

    public List<Movie> retrieveNowShowingMovies(boolean withUpcoming) {
        List<Movie> nowShowingMovies = new ArrayList<Movie>();
        return nowShowingMovies;
    }
}