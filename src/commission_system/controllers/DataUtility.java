/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commission_system.controllers;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 */

public class DataUtility  {
    private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    public static Connection openDBConnection(){
        Connection  con;      
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/Comession_DB","comession","master");
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        catch (SQLException ex) {
            Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }          
          return con;      
    }
    
    public static boolean closeDBConnection(Connection con){
       
        try {  
            if(con !=null)
                con.close();
          
        } catch (SQLException ex) {
            Logger.getLogger(DataUtility.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }      
        return true;
    }
    
    
    public DataUtility() throws Exception {
        try {

            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            connect = DriverManager
                    .getConnection("jdbc:derby://localhost:1527/Comession_DB","comession","master");
            PreparedStatement statement = connect
                    .prepareStatement("SELECT * from FARMER");

            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String user = resultSet.getString("farmer_name");
                String number = resultSet.getString("farmer_id");
                System.out.println("User: " + user);
                System.out.println("ID: " + number);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }

    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) throws Exception {
        DataUtility dao = new DataUtility();
    }

}