/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Staff;
import model.Student;
import model.Teacher;


/**
 *
 * @author goku-
 */
public class DatabaseUtil {
    
    private Connection conn;
    private PreparedStatement ppstmt;
    private Staff staff;
    private Student student;
    private Teacher teacher;

    public DatabaseUtil(Connection conn) {
        this.conn = conn;
    }
    
    public DatabaseUtil() {
    }
    
    public String autheticate(String username, String password){
        // return role of user
        String qrCmd = "SELECT role FROM useraccount ";
        String conditionCmd = "WHERE username = '" + username + "' AND password = '" + password + "';";
        qrCmd = qrCmd + conditionCmd;
        System.out.println(qrCmd);
        try {
            ppstmt = conn.prepareStatement(qrCmd);
            ResultSet rs = ppstmt.executeQuery();
            if(rs.next()){
                return rs.getString("role");
            }
            return "Fail";
        } catch (Exception e) {
            return "Error " + e.toString();
        } 
        
    }
    
    
    
    
}
