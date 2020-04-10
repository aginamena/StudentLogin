
package studentdatabaseaapp;

import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Student class connects each student to the database
 * 
 * @author Agina Oghenemena Benaiah
 * @version 1.0
 */
public class Student {
    private String id;
    
   /**
    * Creates a student object
    * 
    * @param studentId this is the id of each student
    */
    public Student(String studentId){
        id = studentId;
    }
    
    /**
     * Displays a student's information
     * 
     * @param studentId the id of the student
     * @param firstname the first name of the student 
     * @param lastName the last name of the student
     * @param address the address of the student
     * @param phoneNum the phone number of the student
     * @param email the email of the student
     * @param birthday the birthday of the student
     */
    public void displayStudentInfo(JTextField studentId, JTextField firstname, JTextField lastName, 
            JTextField address, JTextField phoneNum, JTextField email, JTextField birthday){
      
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student", 
                    "menaagina", "Polynomial5%");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from students where Student_id = "+id);
            rs.next();
            studentId.setText(rs.getString(1));
            firstname.setText(rs.getString(2));
            lastName.setText(rs.getString(3));
            address.setText(rs.getString(4));
            phoneNum.setText(rs.getString(5));
            email.setText(rs.getString(6));
            birthday.setText(rs.getString(7));        
        } catch (SQLException ex) {
            //an exception will never be thrown
        }
           
    }
}
