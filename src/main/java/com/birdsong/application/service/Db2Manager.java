package com.birdsong.application.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.sql.ResultSet;
import java.sql.SQLException;

//import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.RestController;

import com.birdsong.application.model.*;
//import com.birdsong.application.controller.*;


public class Db2Manager {
    @Value("${db2.url}")
    String urlEndpoint;
    @Value("${db2.user}")
    String username;
    @Value("${db2.password}")
    String password;

    // =========================================
    // The singleton instance.
    // =========================================
    private static Db2Manager instance = null;

    // ===================================================
    // Here is my own **TEMPORARY** connection pool.
    // Current implemention allows only 10 connections
    // to hang around. This is fine at the moment
    // though.
    // ===================================================
    private static Vector<Connection> connectionPool = new Vector<Connection>();
    private final int MAX_POOL_SIZE = 40;

    /**
     *
     * Method Name: Db2Manager
     * 
     * Purpose:     constructor.
     * 
     * @author      Cameron Kubik, Trey Tinnell
     * @date        12/01/2018
     *   
     **/
    private Db2Manager() {

        System.out.println("Entered DBManager::DBManager()");
        String url = urlEndpoint;
        String user = username;
        String pass = password;

        try {
            //======================================
            // Cause the JDBC driver to be loaded.
            //======================================
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            // why is this bad... -cmk
            ///bad 		   jdbcClass = Class.forName("com.ibm.db2.jdbc.app.DB2Driver");
            //		   System.out.println("Loaded the jdbc driver successfully");

            //====================================================================
            // Preload a connection into the pool.  We may want to increase this
            // later.
            //====================================================================
            //	   System.out.println("Pre-loading connection into pool");
            //		DriverManager.getConnection("jdbc:odbc:duffelDB", "", "");
            DriverManager.getConnection(url, user, pass);
            Connection tmp = getConnection();
            releaseConnection(tmp);
            //	   System.out.println("Finished pre-loading connection into pool");

        } catch (java.lang.ClassNotFoundException e) {
            System.err.print("ClassNotFoundException : ");
            System.err.println(e.getMessage());
        } catch (SQLException se) {
            System.out.println("SQL Exception : " + se.getMessage());
        }
        //	  System.out.println("Exiting DBManager::DBManager()");
    }
    
    /**
     *
     * Method Name: getConnection
     * 
     * Purpose: To get a database connection from the connection pool.
     * 
     * @author Trey Tinnell
     * @date 04/04/2000
     * 
     * @return a database connection object.
     * 
     * @exception java.sql.SQLException - raised connecting to the database.
     * 
     **/
    public synchronized Connection getConnection() {
        // System.out.println("Entered getConnection()");
        Connection dbConn = null;

        // ======================================================
        // Try to get the connection from the pool first.
        // ======================================================
        // debug("Pool size: " + connectionPool.size());
        while (connectionPool.size() > 0) {
            // debug("Pool size: " + connectionPool.size());
            dbConn = (Connection) connectionPool.firstElement();
            connectionPool.removeElementAt(0);
            // debug("Used connection from pool");

            // ================================================================
            // Make sure the connection is still OK. For example, the
            // connection may have expired. If it is not ok, then we
            // will call ourselves recursively to get another connection.
            // Note that there is no reason to close the bad connection
            // (because it is already closed) and that the bad connection
            // won't be placed back into the pool.
            // ================================================================
            if (!isConnectionOk(dbConn)) {
                // System.out.println("The connection was bad");
                dbConn = null;
            } else {
                break; // Found a connection, exit loop
            }
        }

        // =============================================================
        // If we couldn't get a connection from the pool, then create
        // a new connection.
        // =============================================================
        if (dbConn == null) {
            String url = urlEndpoint;
            String user = username;
            String pass = password;
            try {

                // System.out.println("Attempting to create a new connection");
                // dbConn = DriverManager.getConnection("jdbc:odbc:duffelDB", "", "");
                dbConn = DriverManager.getConnection(url, user, pass);
                // System.out.println("Successfully got connection");
            } catch (Throwable e) {
                e.printStackTrace();
                System.out.println("Failed to create connection : " + e.getMessage());
                System.err.print("SQL Exception : ");
                System.err.println(e.getMessage());
            }
        }
        // System.out.println("Exiting getConnection()");

        return dbConn;
    }

    /**
     *
     * Method Name: isConnectionOk
     * 
     * Purpose:     Verifies that a database connection is still valid.
     * 
     * @author      Trey Tinnell
     * @date        04/04/2000
     *
     * @param       connection  -- the database connection we are to verify.
     *
     * @return      boolean     -- the status of the connection.
     *     
     **/
    private boolean isConnectionOk(Connection connection) {
	  Statement testStatement = null;

	  try { 
		 if (!connection.isClosed()) {
			//======================================================
			// Try to createStatement to see if it is really alive.
			//======================================================
			testStatement = connection.createStatement();
			testStatement.close();
		 }
		 else {
			return false;
		 }
        } catch (SQLException e) {
            if (testStatement != null) {
                try {
                    testStatement.close();
                } catch (SQLException se) {
                    // Do nothing.
                }
            }
            //		 debug("The connection was not ok.");
            return false;
        }

        return true;
    }
    
    /**
     *
     * Method Name: releaseConnection
     * 
     * Purpose: Returns a database connection to the connection pool.
     * 
     * @author Trey Tinnell
     * @date 04/04/2000
     * 
     * @param conn - connection to release.
     *
     * @return void.
     * 
     **/
    public synchronized void releaseConnection(Connection connection) {
        // ====================================================================
        // If the connection pool doesn't currently hold the max number of
        // connections, add the connection to the connection pool.
        // ====================================================================
        if (connectionPool.size() < MAX_POOL_SIZE) {
            connectionPool.addElement(connection);
            // debug("*****Added connection to Pool.");
            // debug("Pool size: " + connectionPool.size());
        } else {
            // ======================================================
            // The connection pool is full. Delete the connection.
            // ======================================================
            // debug("Connection pool full... Deleted connection instead.");
            try {
                connection.close();
            } catch (Exception e) {
                System.out.println("Exception Releasing connection:" + e.getMessage());
            }
        }
    }
    
    /**
     *
     * Method Name: getInstance
     * 
     * Purpose: To return the single instance of the DBManager class.
     * 
     * @author Trey Tinnell
     * @date 04/04/2000
     * 
     * @return the single instance of the DBManager class.
     * 
     **/
    public static Db2Manager getInstance() {
        if (instance == null) {
            synchronized (Db2Manager.class) {
                if (instance == null) {
                    instance = new Db2Manager();
                }
            }
        }

        return instance;
    }

    public boolean saveMovie(Movie movieToSave) throws Exception {
        boolean saveConfirmation = true;
        Connection databaseConnection = getConnection();
        String query = "SELECT * FROM MOVIES";
        
        try {
            // Create the Statement
            Statement statement = databaseConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            // load table
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.moveToInsertRow();

            // do update
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

        releaseConnection(databaseConnection);

        return saveConfirmation;
    }

    // Home screen content //
    public ArrayList<Movie> getNowShowingMovies() {
        ArrayList<Movie> nowShowingMovies = new ArrayList<Movie>();
        Connection databaseConnection = getConnection();
        String query = "SELECT * FROM MOVIES WHERE isCurrent = TRUE";

        try {
            // Create the Statement, not updatable
            Statement statement = databaseConnection.createStatement();
            
            ResultSet movieResults = statement.executeQuery(query);
            movieResults.beforeFirst();

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

            movieResults.close();
            statement.close();

        } catch (Exception e) {
            System.out.print(e);
        }

        releaseConnection(databaseConnection);

        return nowShowingMovies;
    }

    public ArrayList<SaleItem> getConcessionList() {
        ArrayList<SaleItem> concessionList = new ArrayList<SaleItem>();
        Connection databaseConnection = getConnection();
        String query = "SELECT * FROM SALEITEMS";

        try {
            // Create the Statement, not updatable
            Statement statement = databaseConnection.createStatement();
            ResultSet concessionResults = statement.executeQuery(query);
            concessionResults.beforeFirst();

            while(concessionResults.next()) {
                int itemId = concessionResults.getInt("ITEMID");
                int categoryId = concessionResults.getInt("CATEGORYID");
                String item = concessionResults.getString("ITEM");
                String cost = concessionResults.getString("COST");
                String price = concessionResults.getString("PRICE");
                String discount = concessionResults.getString("DISCOUNT_");
                String imageUri = concessionResults.getString("IMAGEURI");

                SaleItem itemToAdd = new SaleItem(itemId, categoryId, item, cost, price, discount, imageUri);
                concessionList.add(itemToAdd);
            }
            // teardown
            concessionResults.close();
            statement.close();
        } catch (Exception e) {
            System.out.print(e);
        }

        releaseConnection(databaseConnection);

        return concessionList;
    }

    public ArrayList<String> getAboutUsInfo() {
        ArrayList<String> info = new ArrayList<String>();
        Connection databaseConnection = getConnection();
        String query = "SELECT * FROM CONTACTINFO";

        try {
            Statement statement = databaseConnection.createStatement();
            ResultSet aboutUsResults = statement.executeQuery(query);
            aboutUsResults.beforeFirst();

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

        } catch (Exception e) {
            System.out.print(e);
        }

        releaseConnection(databaseConnection);

        return info;
    }
}
