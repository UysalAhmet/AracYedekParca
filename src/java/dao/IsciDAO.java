package dao;

import entity.Isci;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DbConnection;

/**
 *
 * @author H Cem ERYILMAZ
 */

public class IsciDAO {
    
    private DbConnection db;
    private Connection c;
    private UstaDAO ustaDao;

    public List<Isci> getIsciList() {
        List<Isci> isciDaoList = new ArrayList();
        try {
            PreparedStatement pst = this.getC().prepareStatement("select * from isci");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Isci tmp = new Isci();
                tmp.setIsciId(rs.getLong("isci_id"));
                tmp.setIsciAd(rs.getString("isci_ad"));
                tmp.setIsciSoyad(rs.getString("isci_soyad"));
                tmp.setIsciTc(rs.getString("isci_tc"));
                tmp.setUsta(this.getUstaDao().ustaIdBul(rs.getLong("usta_id")));

                isciDaoList.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return isciDaoList;
    }

    public void insert(Isci isci, Long selectedIsci) {

        try {
            PreparedStatement pst = this.getC().prepareStatement("insert into isci "
                    + "(isci_ad,isci_soyad,isci_tc,usta_id) values(?,?,?,?)");
            pst.setString(1, isci.getIsciAd());
            pst.setString(2, isci.getIsciSoyad());
            pst.setString(3, isci.getIsciTc());
            pst.setLong(4, selectedIsci);

            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void delete(Isci isci) {

        try {
            PreparedStatement pst = this.getC().prepareStatement("delete from isci where isci_id=?");
            pst.setLong(1, isci.getIsciId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void update(Isci isci, Long selectedIsci) {

        try {
            PreparedStatement pst = this.getC().prepareStatement("update isci set isci_ad=? ,isci_soyad=?, isci_tc=?, isci_id=?   where isci_id =?");
            pst.setString(1, isci.getIsciAd());
            pst.setString(2, isci.getIsciSoyad());
            pst.setString(3, isci.getIsciTc());
            pst.setLong(4, selectedIsci);
            pst.setLong(5, isci.getIsciId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public Isci isciIdBul(long isciId) {
        Isci isci = null;

        try {

            PreparedStatement pst = this.getC().prepareStatement("select * from isci where isci_id=" + isciId);
            ResultSet rs = pst.executeQuery();
            rs.next();
            isci = new Isci();
            isci.setIsciId(rs.getLong("isci_id"));
            isci.setIsciAd(rs.getString("isci_ad"));
            isci.setIsciSoyad(rs.getString("isci_soyad"));
            isci.setIsciTc(rs.getString("isci_tc"));
            isci.setUsta(this.getUstaDao().ustaIdBul(rs.getLong("isci_id")));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return isci;
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

    public UstaDAO getUstaDao() {
        if (this.ustaDao == null) {
            this.ustaDao = new UstaDAO();
        }
        return ustaDao;
    }
}
