
package studentdatabaseaapp;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;
/**
 * Admin is able to see each student and their information registered in the database
 * 
 * @author Agina Oghenemena Benaiah
 * @version 1.0
 */
public class Admin {
    private static String url = "jdbc:mysql://localhost:3306/Student";
    private static String password = "Polynomial5%";
    private static String userName1 = "menaagina";
    private static String userName2 = "root";
    
    public Admin(){
        
    }
    
    /**
     * IsAdmin makes a check to see if it's actually the admin trying to login
     * to the database
     * 
     * @param userName the admin's username
     * @param password the admin's password
     * 
     * @return return strue if username and password are correct to login
     * as the admin. Otherwise false
     */
    public boolean isAdmin(String userName, String password){
        return userName.equals(userName1) || userName.equals(userName2)
                && password.equals(this.password);
    }
    
    /**
     * Displays students information on a table 
     * 
     * @param table displays all students information on the table
     * @param rs gets the result from the database
     */
    public void displayStudentInfo(JTable table, ResultSet rs){
        table.setModel(DbUtils.resultSetToTableModel(rs));
    }
   
    
    
}
