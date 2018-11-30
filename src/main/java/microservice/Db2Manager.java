package microservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Db2Manager {

    Connection databaseConnection;
    Statement statement;
    boolean isConnected = false;

    @Value("${db2.url}")
    String urlEndpoint;
    @Value("${db2.user}")
    String username;
    @Value("${db2.password}")
    String password;

    public Db2Manager() {}

    public boolean initializeConnection() {
        String url = urlEndpoint;
        String user = username;
        String pass = password;

        if (isConnected) {
            return true;
        }

        try {
            // Load the driver
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            System.out.print(url);
            // Create the connection using the IBM Data Server Driver for JDBC and SQLJ
            databaseConnection = DriverManager.getConnection(url, user, pass); 
            // Commit changes manually
            databaseConnection.setAutoCommit(false);
            isConnected = true;

        } catch (Exception e) {
            System.out.print(e);
            e.printStackTrace();

            isConnected = false;
        }

        return isConnected;
    }

    public boolean saveMovie(Movie movieToSave) throws Exception {
        // Create the Statement
        statement = databaseConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        boolean saveConfirmation = true;

        try {
            // load table
            ResultSet resultSet = statement.executeQuery("SELECT * FROM MOVIES");
            // do update
            resultSet.moveToInsertRow();
            resultSet.updateInt("MOVIEID", movieToSave.getId());
            resultSet.updateString("TITLE", movieToSave.getTitle());
            resultSet.updateInt("DURATION", movieToSave.getDuration());
            resultSet.updateString("IMAGEURI", movieToSave.getPosterImagePath());
            resultSet.updateInt("ISCURRENT", movieToSave.getIsCurrentShowing());
            resultSet.updateInt("ISUPCOMING", movieToSave.getIsUpcomingShowing());
            resultSet.insertRow();
            resultSet.moveToCurrentRow();
            // teardown
            resultSet.close();
            statement.close();
            databaseConnection.commit();
            //databaseConnection.close();
        } catch (Exception e) {
            System.out.print(e);
            saveConfirmation = false;
        }

        return saveConfirmation;
    }

    public ArrayList<Movie> getNowShowingMovies() throws Exception {
        String query = "SELECT * FROM MOVIES WHERE isCurrent = TRUE";
        ResultSet movieResults = null;
        ArrayList<Movie> nowShowingMovies = new ArrayList<Movie>();
        // Create the Statement
        statement = databaseConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

        try {
            movieResults = statement.executeQuery(query);
            movieResults.first();

            while (!movieResults.isAfterLast()) {
                int id = movieResults.getInt("MOVIEID");
                String title = movieResults.getString("TITLE");
                int duration = movieResults.getInt("DURATION");
                String imageUri = movieResults.getString("IMAGEURI");
                int isCurrent = movieResults.getInt("ISCURRENT");
                int isUpcoming = movieResults.getInt("ISUPCOMING");

                Movie nowShowingMovie = new Movie(title, id, imageUri, "", "", "", duration, isCurrent, isUpcoming);
                nowShowingMovies.add(nowShowingMovie);
                movieResults.next();
            }
        } catch (Exception e) {
            System.out.print(e);
        }
        
        if (movieResults != null) {
            movieResults.close();
        }
        
        statement.close();

        return nowShowingMovies;
    }
}
