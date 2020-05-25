/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ahmet
 */
public class DbConnection {
    
    
    public  Connection connect(){
        Connection c=null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/AracYedekParca?user=root&password=1453");
            System.out.println("Basarılı");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            System.out.println(ex.getMessage());    
        }
        
        return c;
    }
    
}
