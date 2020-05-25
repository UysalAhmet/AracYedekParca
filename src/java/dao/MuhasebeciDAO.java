package dao;

import entity.Muhasebeci;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DbConnection;

/**
 *
 * @author gkhnya
 */

public class MuhasebeciDAO {

    private DbConnection db;
    private Connection c;

    public List<Muhasebeci> getMuhasebeciList() {
        List<Muhasebeci> muhasebeciDaoList = new ArrayList();
        try {
            PreparedStatement pst = this.getC().prepareStatement("select * from muhasebeci");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Muhasebeci tmp = new Muhasebeci();
                tmp.setMuhasebeciId(rs.getLong("muhasebeci_id"));
                tmp.setMuhasebeciAd(rs.getString("muhasebeci_ad"));
                tmp.setMuhasebeciSoyad(rs.getString("muhasebeci_soyad"));
                tmp.setMuhasebeciTc(rs.getString("muhasebeci_tc"));

                muhasebeciDaoList.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return muhasebeciDaoList;
    }

    public void insert(Muhasebeci muhasebeci) {

        try {
            PreparedStatement pst = this.getC().prepareStatement("insert into muhasebeci "
                    + "(muhasebeci_ad,muhasebeci_soyad,muhasebeci_tc) values(?,?,?)");
            pst.setString(1, muhasebeci.getMuhasebeciAd());
            pst.setString(2, muhasebeci.getMuhasebeciSoyad());
            pst.setString(3, muhasebeci.getMuhasebeciTc());

            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void delete(Muhasebeci muhasebeci) {

        try {
            PreparedStatement pst = this.getC().prepareStatement("delete from muhasebeci where muhasebeci_id=?");
            pst.setLong(1, muhasebeci.getMuhasebeciId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void update(Muhasebeci muhasebeci) {

        try {
            PreparedStatement pst = this.getC().prepareStatement("update muhasebeci set muhasebeci_ad=? ,muhasebeci_soyad=?, muhasebeci_tc=?   where muhasebeci_id =?");
            pst.setString(1, muhasebeci.getMuhasebeciAd());
            pst.setString(2, muhasebeci.getMuhasebeciSoyad());
            pst.setString(3, muhasebeci.getMuhasebeciTc());
            pst.setLong(4, muhasebeci.getMuhasebeciId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public Muhasebeci muhasebeciIdBul(Long muhasebeciId) {
        Muhasebeci muhasebeci = null;

        try {

            PreparedStatement pst = this.getC().prepareStatement("select * from muhasebeci where muhasebeci_id=" + muhasebeciId);
            ResultSet rs = pst.executeQuery();
            rs.next();
            muhasebeci = new Muhasebeci();
            muhasebeci.setMuhasebeciId(rs.getLong("muhasebeci_id"));
            muhasebeci.setMuhasebeciAd(rs.getString("muhasebeci_ad"));
            muhasebeci.setMuhasebeciSoyad(rs.getString("muhasebeci_soyad"));
            muhasebeci.setMuhasebeciTc(rs.getString("muhasebeci_tc"));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return muhasebeci;
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

}
