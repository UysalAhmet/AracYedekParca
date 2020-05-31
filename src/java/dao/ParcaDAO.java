/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Parca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DbConnection;

/**
 *
 * @author ahmet
 */
public class ParcaDAO {
     private DbConnection db;
    private Connection c;
    private MakinaDAO makinaDao;

    public List<Parca> getParcaList(int page,int pageSize) {
        List<Parca> parcaDaoList = new ArrayList();
          int start=(page-1)*pageSize;
        try {
            PreparedStatement pst = this.getC().prepareStatement("select * from parca  order by parca_id asc limit "+start+","+pageSize);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Parca tmp = new Parca();
                tmp.setParcaId(rs.getLong("parca_id"));
                tmp.setParcaAd(rs.getString("parca_ad"));
                tmp.setParcaHammadde(rs.getString("parca_hammadde"));
                tmp.setParcaFiyat(rs.getLong("parca_fiyat"));
                tmp.setMakina(this.getMakinaDao().makinaIdBul(rs.getLong("makina_id")));

                parcaDaoList.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return parcaDaoList;
    }
    
     public int count() {
         int count =0;
        try {
            PreparedStatement pst = this.getC().prepareStatement("select count(parca_id) as parca_count from parca");
            ResultSet rs = pst.executeQuery();
            rs.next();
           count=rs.getInt("parca_count");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

    public List<Parca> getParcaList() {
        List<Parca> parcaDaoList = new ArrayList();
        try {
            PreparedStatement pst = this.getC().prepareStatement("select * from parca");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Parca tmp = new Parca();
                tmp.setParcaId(rs.getLong("parca_id"));
                tmp.setParcaAd(rs.getString("parca_ad"));
                tmp.setParcaHammadde(rs.getString("parca_hammadde"));
                tmp.setParcaFiyat(rs.getLong("parca_fiyat"));
                tmp.setMakina(this.getMakinaDao().makinaIdBul(rs.getLong("makina_id")));

                parcaDaoList.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return parcaDaoList;
    }

    public void insert(Parca parca) {
        System.out.println("insert metodu");
        try {
            PreparedStatement pst = this.getC().prepareStatement("insert into parca "
                    + "(parca_ad,parca_hammadde,parca_fiyat,makina_id) values(?,?,?,?)");
            pst.setString(1, parca.getParcaAd());
            pst.setString(2, parca.getParcaHammadde());
            pst.setLong(3, parca.getParcaFiyat());
            pst.setLong(4, parca.getMakina().getMakinaId());

            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void delete(Parca parca) {

        try {
            PreparedStatement pst = this.getC().prepareStatement("delete from parca where parca_id=?");
            pst.setLong(1, parca.getParcaId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void update(Parca parca) {

        try {
            PreparedStatement pst = this.getC().prepareStatement("update parca set parca_ad=? ,parca_hammadde=?, parca_fiyat=?, makina_id=?   where parca_id =?");
            pst.setString(1, parca.getParcaAd());
            pst.setString(2, parca.getParcaHammadde());
            pst.setLong(3, parca.getParcaFiyat());
            pst.setLong(4, parca.getMakina().getMakinaId());
            pst.setLong(5, parca.getParcaId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public Parca parcaIdBul(long parcaId) {
        Parca parca = null;

        try {

            PreparedStatement pst = this.getC().prepareStatement("select * from parca where parca_id=" + parcaId);
            ResultSet rs = pst.executeQuery();
            rs.next();
            parca = new Parca();
            parca.setParcaId(rs.getLong("parca_id"));
            parca.setParcaAd(rs.getString("parca_ad"));
            parca.setParcaHammadde(rs.getString("parca_hammadde"));
            parca.setParcaFiyat(rs.getLong("parca_fiyat"));
            parca.setMakina(this.getMakinaDao().makinaIdBul(rs.getLong("makina_id")));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return parca;
    }

    public DbConnection getDb() {
        if (this.db == null) {
            this.db = new DbConnection();
        }
        return db;
    }

    public void setDb(DbConnection db) {
        this.db = db;
    }

    public Connection getC() {
        if (this.c == null) {
            this.c = getDb().connect();
        }
        return c;
    }

    public void setC(Connection c) {
        this.c = c;
    }

    public MakinaDAO getMakinaDao() {
        if (this.makinaDao == null) {
            this.makinaDao = new MakinaDAO();
        }
        return makinaDao;
    }

    
}
