package microservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;

import org.json.JSONObject;
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
            // Create the Statement
            statement = databaseConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
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

    public ArrayList<Movie> getNowShowingMovies() {
        String query = "SELECT * FROM MOVIES WHERE isCurrent = TRUE";

        ResultSet movieResults;

        try {
            movieResults = statement.executeQuery(query);
            while (!movieResults.isAfterLast()) {
                movieResults.first();

                int id = movieResults.getInt("MOVIEID");
                String title = movieResults.getString("TITLE");
                int duration = movieResults.getInt("DURATION");
                String imageUri = movieResults.getString("IMAGEURI");
                int isCurrent = movieResults.getInt("ISCURRENT");
                int isUpcoming = movieResults.getInt("ISUPCOMING");

                //Movie nowShowingMovie = new Movie()
            }
            

        } catch (Exception e) {
            System.out.print(e);
        }
        

        ArrayList<Movie> nowShowingMovies = new ArrayList<Movie>();
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
            // teardown
            concessionResults.close();
            statement.close();
            databaseConnection.commit();
        } catch (Exception e) {
            System.out.print(e);
        }

        return concessionList;
    }

    public ArrayList<String> getAboutUsInfo() {
        String query = "SELECT * FROM CONTACTINFO";
        ResultSet aboutUsResults;
        ArrayList<String> info = new ArrayList<String>();

        try {
            statement = databaseConnection.createStatement();
            aboutUsResults = statement.executeQuery(query);

            while(aboutUsResults.next()) {
                String address = aboutUsResults.getString("ADDRESS");
                String phone = aboutUsResults.getString("PHONE");
                String facebook = aboutUsResults.getString("FACEBOOK");
                String twitter = aboutUsResults.getString("TWITTER");
                String instagram = aboutUsResults.getString("INSTAGRAM");

                info.add(address);
                info.add(phone);
                info.add(facebook);
                info.add(twitter);
                info.add(instagram);
            }
            // teardown
            aboutUsResults.close();
            statement.close();
            databaseConnection.commit();
        } catch (Exception e) {
            System.out.print(e);
        }

        return info;
    }
}
