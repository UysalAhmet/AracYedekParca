package dao;

/**
 *
 * @author H Cem ERYILMAZ
 */

import entity.Usta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DbConnection;

public class UstaDAO {

    private DbConnection db;
    private Connection c;

    public List<Usta> getUstaList() {
        List<Usta> ustaDaoList = new ArrayList();
        try {
            PreparedStatement pst = this.getC().prepareStatement("select * from usta");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Usta tmp = new Usta();
                tmp.setUstaId(rs.getLong("usta_id"));
                tmp.setUstaAd(rs.getString("usta_ad"));
                tmp.setUstaSoyad(rs.getString("usta_soyad"));
                tmp.setUstaTc(rs.getString("usta_tc"));

                ustaDaoList.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ustaDaoList;
    }

    public void insert(Usta usta) {

        try {
            PreparedStatement pst = this.getC().prepareStatement("insert into usta "
                    + "(usta_ad,usta_soyad,usta_tc) values(?,?,?)");
            pst.setString(1, usta.getUstaAd());
            pst.setString(2, usta.getUstaSoyad());
            pst.setString(3, usta.getUstaTc());

            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void delete(Usta usta) {

        try {
            PreparedStatement pst = this.getC().prepareStatement("delete from usta where usta_id=?");
            pst.setLong(1, usta.getUstaId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void update(Usta usta) {

        try {
            PreparedStatement pst = this.getC().prepareStatement("update usta set usta_ad=? ,usta_soyad=?, usta_tc=?   where usta_id =?");
            pst.setString(1, usta.getUstaAd());
            pst.setString(2, usta.getUstaSoyad());
            pst.setString(3, usta.getUstaTc());
            pst.setLong(4, usta.getUstaId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public Usta ustaIdBul(Long ustaId) {
        Usta usta = null;

        try {

            PreparedStatement pst = this.getC().prepareStatement("select * from usta where usta_id=" + ustaId);
            ResultSet rs = pst.executeQuery();
            rs.next();
            usta = new Usta();
            usta.setUstaId(rs.getLong("usta_id"));
            usta.setUstaAd(rs.getString("usta_ad"));
            usta.setUstaSoyad(rs.getString("usta_soyad"));
            usta.setUstaTc(rs.getString("usta_tc"));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return usta;
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
