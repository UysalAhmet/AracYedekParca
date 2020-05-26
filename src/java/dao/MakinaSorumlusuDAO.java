/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author yasemin
 */
import entity.MakinaSorumlusu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DbConnection;





public class MakinaSorumlusuDAO {
    
    private DbConnection db;
    private Connection c;

  
    
    public List<MakinaSorumlusu> getMakinaSorumlusuList() {
         List<MakinaSorumlusu> makinaSorumlusuDaoList = new ArrayList();
        try {
            PreparedStatement pst = this.getC().prepareStatement("select * from makinaSorumlusu");
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                MakinaSorumlusu tmp = new MakinaSorumlusu();
                tmp.setMakinasorumlusuId(rs.getLong("makinaSorumlusu_id"));
                tmp.setMakinasorumlusuAd(rs.getString("makinaSorumlusu_ad"));
                tmp.setMakinasorumlusuSoyad(rs.getString("makinaSorumlusu_soyad"));
                tmp.setMakinasorumlusuTc(rs.getString("makinaSorumlusu_tc"));
               
                
                makinaSorumlusuDaoList.add(tmp);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return makinaSorumlusuDaoList;
    }


    public void insert(MakinaSorumlusu makinaSorumlusu) {
      
    try{
            PreparedStatement pst = this.getC().prepareStatement("insert into makinaSorumlusu "
                    + "(makinaSorumlusu_ad,makinaSorumlusu_soyad,makinaSorumlusu_tc) values(?,?,?)");
            pst.setString(1, makinaSorumlusu.getMakinasorumlusuAd());
            pst.setString(2, makinaSorumlusu.getMakinasorumlusuSoyad());
            pst.setString(3, makinaSorumlusu.getMakinasorumlusuTc());
            
            pst.executeUpdate();
           
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
    }

    public void delete(MakinaSorumlusu makinaSorumlusu) {
    
         try{
            PreparedStatement pst = this.getC().prepareStatement("delete from makinaSorumlusu where makinaSorumlusu_id=?");
            pst.setLong(1, makinaSorumlusu.getMakinasorumlusuId());
            pst.executeUpdate();
            } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    
    }

    public void update(MakinaSorumlusu makinaSorumlusu) {
    
         try{
            PreparedStatement pst = this.getC().prepareStatement("update makinaSorumlusu set makinaSorumlusu_ad=? ,makinaSorumlusu_soyad=?, makinaSorumlusu_tc=?   where makinaSorumlusu_id =?");
            pst.setString(1, makinaSorumlusu.getMakinasorumlusuAd());
            pst.setString(2, makinaSorumlusu.getMakinasorumlusuSoyad());
            pst.setString(3, makinaSorumlusu.getMakinasorumlusuTc());
            pst.setLong(4, makinaSorumlusu.getMakinasorumlusuId());
            pst.executeUpdate();
            } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
    
    }
    
    
    public MakinaSorumlusu makinaSorumlusuIdBul(Long makinaSorumlusuId){
        MakinaSorumlusu makinaSorumlusu=null;
        
        try{
            
            PreparedStatement pst = this.getC().prepareStatement("select * from makinaSorumlusu where makinaSorumlusu_id="+makinaSorumlusuId);
            ResultSet rs =pst.executeQuery();
            rs.next();
            makinaSorumlusu=new MakinaSorumlusu();
            makinaSorumlusu.setMakinasorumlusuId(rs.getLong("makinaSorumlusu_id"));
            makinaSorumlusu.setMakinasorumlusuAd(rs.getString("makinaSorumlusu_ad"));
            makinaSorumlusu.setMakinasorumlusuSoyad(rs.getString("makinaSorumlusu_soyad"));
            makinaSorumlusu.setMakinasorumlusuTc(rs.getString("makinaSorumlusu_tc"));
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return makinaSorumlusu;
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