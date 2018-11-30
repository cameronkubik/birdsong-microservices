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
        boolean saveConfirmation = true;
            // Create the Statement
            statement = databaseConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

        try {
            // Create the Statement
            statement = databaseConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
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

    public ArrayList<Movie> getNowShowingMovies() {
        String query = "SELECT * FROM MOVIES WHERE isCurrent = TRUE";
        ResultSet movieResults = null;
        ArrayList<Movie> nowShowingMovies = new ArrayList<Movie>();

        try {
            // Create the Statement
            statement = databaseConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
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
        
                if (movieResults != null) {
                    movieResults.close();
                }
                
            }

            movieResults.close();
            statement.close();

        } catch (Exception e) {
            System.out.print(e);
        }

        return nowShowingMovies;
    }

    public ArrayList<ConcessionItem> getConcessionList() {
        String query = "SELECT * FROM SALEITEMS";
        ResultSet concessionResults;
        ArrayList<ConcessionItem> concessionList = new ArrayList<ConcessionItem>();

        try {
            statement = databaseConnection.createStatement();
            concessionResults = statement.executeQuery(query);

            while(concessionResults.next()) {
                int itemId = concessionResults.getInt("ITEMID");
                int categoryId = concessionResults.getInt("CATEGORYID");
                String item = concessionResults.getString("ITEM");
                String cost = concessionResults.getString("COST");
                String price = concessionResults.getString("PRICE");
                String discount = concessionResults.getString("DISCOUNT_");
                String imageUri = concessionResults.getString("IMAGEURI");

                ConcessionItem itemToAdd = new ConcessionItem(itemId, categoryId, item, cost, price, discount, imageUri);
                concessionList.add(itemToAdd);
            }
            statement.close();
        } catch (Exception e) {
            System.out.print(e);
        }

        return concessionList;
    }


    public String getSpecialEventText() {
        String specialEventText = "There are no special events at this time";
        return specialEventText;
    }
    public String getWelcomeMesssageText() {
        String welcomeMessageText = "Welcome to Birdsong Theaters! We're a family owned and operated Drive-In movie theater located in Camden, Tennessee.";
        return welcomeMessageText;

        //String query = "SELECT * FROM THEATERINFO";
        // ResultSet messageResults;

        // try {
        //     statement = databaseConnection.createStatement();
        //     concessionResults = statement.executeQuery(query);

        //     while(concessionResults.next()) {
        //         int itemId = concessionResults.getInt("ITEMID");
        //         int categoryId = concessionResults.getInt("CATEGORYID");
        //         String item = concessionResults.getString("ITEM");
        //         String cost = concessionResults.getString("COST");
        //         String price = concessionResults.getString("PRICE");
        //         String discount = concessionResults.getString("DISCOUNT_");
        //         String imageUri = concessionResults.getString("IMAGEURI");

        //         ConcessionItem itemToAdd = new ConcessionItem(itemId, categoryId, item, cost, price, discount, imageUri);
        //         concessionList.add(itemToAdd);
        //     }
        //     statement.close();
        // } catch (Exception e) {
        //     System.out.print(e);
        // }

        // return concessionList;
    }
}
