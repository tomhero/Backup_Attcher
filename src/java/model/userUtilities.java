/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Administrator
 */
public class userUtilities {
    
    user us = new user();
    Connection conn;
    Statement stmt;
    
    public void init(){
       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://database.it.kmitl.ac.th:3306/it_15";
            String user = "it_15";
            String pwd = "mwGxJhMp";
            conn = DriverManager.getConnection(url, user, pwd);
            stmt = conn.createStatement();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(userUtilities.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(userUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//    public int insertData(user us){
//        String sqlCmd = "insert into customerdata values('"+ us.getUsername() + "','" 
//                    + us.getPassword() + "')";
//        int num = 0;
//        
//        try {
//            System.out.print(sqlCmd);
//            num = stmt.executeUpdate(sqlCmd);
//        } catch (Exception ex) {
//            Logger.getLogger(userUtilities.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return num;
//    }
    
    public String getData(user us){
        String sqlCmd = "select username, password, role from useraccount";
        try {
            System.out.print(sqlCmd);
            ResultSet rs = stmt.executeQuery(sqlCmd);
            while(rs.next()){
                System.out.println(rs.getString("username"));
                System.out.println(us.getUsername());
                if(rs.getString("username").equalsIgnoreCase(us.getUsername()) && rs.getString("password").equals(us.getPassword())){
                    return rs.getString("role");
                }
        }
        } catch (Exception ex) {
            Logger.getLogger(userUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "fail";
    }
    
}
