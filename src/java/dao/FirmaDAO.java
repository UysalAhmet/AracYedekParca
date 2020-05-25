package dao;

import entity.Firma;
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

public class FirmaDAO {

    private DbConnection db;
    private Connection c;

    public List<Firma> getFirmaList() {
        List<Firma> firmaDaoList = new ArrayList();
        try {
            PreparedStatement pst = this.getC().prepareStatement("select * from firma");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Firma tmp = new Firma();
                tmp.setFirmaId(rs.getLong("firma_id"));
                tmp.setFirmaAd(rs.getString("firma_ad"));
                tmp.setFirmaAciklama(rs.getString("firma_aciklama"));

                firmaDaoList.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return firmaDaoList;
    }

    public void insert(Firma firma) {

        try {
            PreparedStatement pst = this.getC().prepareStatement("insert into firma "
                    + "(firma_ad,firma_aciklama) values(?,?)");
            pst.setString(1, firma.getFirmaAd());
            pst.setString(2, firma.getFirmaAciklama());

            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void delete(Firma firma) {

        try {
            PreparedStatement pst = this.getC().prepareStatement("delete from firma where firma_id=?");
            pst.setLong(1, firma.getFirmaId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void update(Firma firma) {

        try {
            PreparedStatement pst = this.getC().prepareStatement("update firma set firma_ad=? ,firma_aciklama=? where firma_id =?");
            pst.setString(1, firma.getFirmaAd());
            pst.setString(2, firma.getFirmaAciklama());
            pst.setLong(3, firma.getFirmaId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public Firma firmaIdBul(Long firmaId) {
        Firma firma = null;

        try {

            PreparedStatement pst = this.getC().prepareStatement("select * from firma where firma_id=" + firmaId);
            ResultSet rs = pst.executeQuery();
            rs.next();
            firma = new Firma();
            firma.setFirmaId(rs.getLong("firma_id"));
            firma.setFirmaAd(rs.getString("firma_ad"));
            firma.setFirmaAciklama(rs.getString("firma_aciklama"));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return firma;
    }

    public List<Firma> getSiparisVerenFirmalar(Long siparisId) {
        List<Firma> siparisVerenFirmalar = new ArrayList<>();
        try {
            PreparedStatement pst = this.getC().prepareStatement("select * from firma_siparis where siparis_id=" + siparisId);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                siparisVerenFirmalar.add(this.firmaIdBul(rs.getLong("Firma_id")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return siparisVerenFirmalar;
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
