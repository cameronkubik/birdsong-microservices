package microservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Db2Manager {

    Connection databaseConnection;
    Statement statement;

    @Value("${db2.url}")
    String urlEndpoint;
    @Value("${db2.user}")
    String username;
    @Value("${db2.password}")
    String password;

    public Db2Manager() {}

    public boolean initializeConnection() throws Exception {
        boolean connectionSuccessful = true;
        String url = urlEndpoint;
        String user = username;
        String pass = password;

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

        } catch (Exception e) {
            System.out.print(e);
            e.printStackTrace();

            connectionSuccessful = false;
        }

        return connectionSuccessful;
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
            databaseConnection.close();
        } catch (Exception e) {
            System.out.print(e);
            saveConfirmation = false;
        }

        return saveConfirmation;
    }

    
}
