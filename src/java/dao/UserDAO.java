/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DbConnection;
import entity.User;

/**
 *
 * @author ahmet
 */
public class UserDAO {
      private DbConnection db;
    private Connection c;

   public List<User> getUserList(int page,int pageSize) {
         List<User> userDaoList = new ArrayList();
                  int start=(page-1)*pageSize;
        try {
            PreparedStatement pst = this.getC().prepareStatement("select * from user order by kullanici_ad asc limit "+start+","+pageSize);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                User tmp = new User();
                tmp.setKullaniciAd(rs.getString("kullanici_ad"));
                tmp.setSifre(rs.getString("sifre"));
                
                
                userDaoList.add(tmp);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return userDaoList;
    }
public int count() {
         int count =0;
        try {
            PreparedStatement pst = this.getC().prepareStatement("select count(kullanici_ad) as user_count from user");
            ResultSet rs = pst.executeQuery();
            rs.next();
           count=rs.getInt("user_count");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }
    
    public List<User> getUserList() {
         List<User> userDaoList = new ArrayList();
        try {
            PreparedStatement pst = this.getC().prepareStatement("select * from user");
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                User tmp = new User();
                tmp.setKullaniciAd(rs.getString("kullanici_ad"));
                tmp.setSifre(rs.getString("sifre"));
                
                
                userDaoList.add(tmp);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return userDaoList;
    }


    public void insert(User user) {
      
    try{
            PreparedStatement pst = this.getC().prepareStatement("insert into user "
                    + "(kullanici_ad,sifre) values(?,?)");
            pst.setString(1, user.getKullaniciAd());
            pst.setString(2, user.getSifre());
            
            pst.executeUpdate();
           
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
    }

    public void delete(User user) {
    
         try{
            PreparedStatement pst = this.getC().prepareStatement("delete from user where kullanici_ad=?");
            pst.setString(1, user.getKullaniciAd());
            pst.executeUpdate();
            } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    
    }

    public void update(User user) {
    
         try{
            PreparedStatement pst = this.getC().prepareStatement("update user set sifre=? where kullanici_ad =?");
            pst.setString(1, user.getSifre());
            pst.setString(2, user.getKullaniciAd());
            pst.executeUpdate();
            } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
    
    }
    
    
    public User userIdBul(String kullaniciAd){
        User user=null;
        
        try{
            
            PreparedStatement pst = this.getC().prepareStatement("select * from user where kullanici_ad='"+kullaniciAd+"'");
            ResultSet rs =pst.executeQuery();
            rs.next();
            user=new User();
            user.setKullaniciAd(rs.getString("kullanici_ad"));
            user.setSifre(rs.getString("sifre"));
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return user;
    }
       
    public DbConnection getDb() {
        if(this.db==null){
            this.db=new DbConnection();
        }
        return db;
    }

    public void setDb(DbConnection db) {
        this.db = db;
    }

    public Connection getC() {
        if(this.c==null){
            this.c= getDb().connect();
        }
        return c;
    }

    public void setC(Connection c) {
        this.c = c;
    }
}
