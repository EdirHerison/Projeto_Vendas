/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author edir_
 */
public class ConnectionFactory {
    
    public Connection getConnection(){
         try{
          return DriverManager.getConnection("jdbc:mysql://localhost:3306/bdvendas","root","herison145792");
         }catch(SQLException e){
             throw new RuntimeException("erro !!!" + e);
         }
    }
    
   
    
}
