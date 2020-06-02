package dao;

import entity.Firma;
import entity.Siparis;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DbConnection;

/**
 *
 * @author ahmet
 */

public class SiparisDAO {

    private DbConnection db;
    private Connection c;
    private MuhasebeciDAO muhasebeciDao;
    private ParcaDAO parcaDao;
    private FirmaDAO firmaDao;

    public List<Siparis> getSiparisList(int page, int pageSize) {
        List<Siparis> siparisDaoList = new ArrayList();
        int start = (page - 1) * pageSize;
        try {
            PreparedStatement pst = this.getC().prepareStatement("select * from siparis order by siparis_id asc limit " + start + "," + pageSize);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Siparis tmp = new Siparis();
                tmp.setSiparisId(rs.getLong("siparis_id"));
                tmp.setSiparisKod(rs.getString("siparis_kod"));
                tmp.setSiparisParcaSayi(rs.getLong("siparis_parcasayi"));
                tmp.setParca(this.getParcaDao().parcaIdBul(rs.getLong("parca_id")));
                tmp.setMuhasebeci(this.getMuhasebeciDao().muhasebeciIdBul(rs.getLong("muhasebeci_id")));
                tmp.setSiparisVerenFirmalar(this.getFirmaDao().getSiparisVerenFirmalar(tmp.getSiparisId()));
                siparisDaoList.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return siparisDaoList;
    }

    public int count() {
        int count = 0;
        try {
            PreparedStatement pst = this.getC().prepareStatement("select count(siparis_id) as siparis_count from siparis");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("siparis_count");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

    public List<Siparis> getSiparisList() {
        List<Siparis> siparisDaoList = new ArrayList();
        try {
            PreparedStatement pst = this.getC().prepareStatement("select * from siparis");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Siparis tmp = new Siparis();
                tmp.setSiparisId(rs.getLong("siparis_id"));
                tmp.setSiparisKod(rs.getString("siparis_kod"));
                tmp.setSiparisParcaSayi(rs.getLong("siparis_parcasayi"));
                tmp.setParca(this.getParcaDao().parcaIdBul(rs.getLong("parca_id")));
                tmp.setMuhasebeci(this.getMuhasebeciDao().muhasebeciIdBul(rs.getLong("muhasebeci_id")));
                tmp.setSiparisVerenFirmalar(this.getFirmaDao().getSiparisVerenFirmalar(tmp.getSiparisId()));
                siparisDaoList.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return siparisDaoList;
    }

    public Siparis siparisIdBul(Long siparisId) {
        Siparis siparis = null;

        try {

            PreparedStatement pst = this.getC().prepareStatement("select * from siparis where siparis_id=" + siparisId);
            ResultSet rs = pst.executeQuery();
            rs.next();
            siparis = new Siparis();
            siparis.setSiparisId(rs.getLong("siparis_id"));
            siparis.setSiparisKod(rs.getString("siparis_kod"));
            siparis.setSiparisParcaSayi(rs.getLong("siparis_parcasayi"));
            siparis.setParca(this.getParcaDao().parcaIdBul(rs.getLong("parca_id")));
            siparis.setMuhasebeci(this.getMuhasebeciDao().muhasebeciIdBul(rs.getLong("muhasebeci_id")));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return siparis;
    }

    public void insert(Siparis siparis) {

        try {
            PreparedStatement pst = this.getC().prepareStatement("insert into siparis "
                    + "(siparis_kod,siparis_parcasayi,muhasebeci_id,parca_id) values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, siparis.getSiparisKod());
            pst.setLong(2, siparis.getSiparisParcaSayi());
            pst.setLong(3, siparis.getMuhasebeci().getMuhasebeciId());
            pst.setLong(4, siparis.getParca().getParcaId());
            pst.executeUpdate();
            Long siparisId = null;
            ResultSet gk = pst.getGeneratedKeys();

            if (gk.next()) {
                siparisId = gk.getLong(1);
            }
            for (Firma a : siparis.getSiparisVerenFirmalar()) {
                PreparedStatement pst2 = this.getC().prepareStatement("insert into firma_siparis "
                        + "(siparis_id,firma_id) values(?,?)");
                pst2.setLong(1, siparisId);
                pst2.setLong(2, a.getFirmaId());
                pst2.executeUpdate();
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void delete(Siparis siparis) {

        try {
            PreparedStatement pst2 = this.getC().prepareStatement("delete from firma_siparis where siparis_id=?");
            pst2.setLong(1, siparis.getSiparisId());
            pst2.executeUpdate();

            PreparedStatement pst = this.getC().prepareStatement("delete from siparis where siparis_id=?");
            pst.setLong(1, siparis.getSiparisId());
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void update(Siparis siparis) {

        try {
            PreparedStatement pst = this.getC().prepareStatement("update siparis set siparis_kod=? ,siparis_parcasayi=?, muhasebeci_id=?, parca_id=?   where siparis_id =?");
            pst.setString(1, siparis.getSiparisKod());
            pst.setLong(2, siparis.getSiparisParcaSayi());
            pst.setLong(3, siparis.getMuhasebeci().getMuhasebeciId());
            pst.setLong(4, siparis.getParca().getParcaId());
            pst.setLong(5, siparis.getSiparisId());
            pst.executeUpdate();
            pst = this.getC().prepareStatement("delete from firma_siparis where siparis_id=?");
            pst.setLong(1, siparis.getSiparisId());
            pst.executeUpdate();
            for (Firma a : siparis.getSiparisVerenFirmalar()) {
                PreparedStatement pst2 = this.getC().prepareStatement("insert into firma_siparis "
                        + "(siparis_id,firma_id) values(?,?)");
                pst2.setLong(1, siparis.getSiparisId());
                pst2.setLong(2, a.getFirmaId());
                pst2.executeUpdate();
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public List<Siparis> getVerilenSiparisler(Long firmaId) {
        List<Siparis> verilenSiparisler = new ArrayList<>();
        try {
            PreparedStatement pst = this.getC().prepareStatement("select * from firma_siparis where firma_id=" + firmaId);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                verilenSiparisler.add(this.siparisIdBul(rs.getLong("siparis_id")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return verilenSiparisler;
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

    public MuhasebeciDAO getMuhasebeciDao() {
        if (this.muhasebeciDao == null) {
            this.muhasebeciDao = new MuhasebeciDAO();
        }
        return muhasebeciDao;
    }

    public ParcaDAO getParcaDao() {
        if (this.parcaDao == null) {
            this.parcaDao = new ParcaDAO();
        }
        return parcaDao;
    }

    public FirmaDAO getFirmaDao() {
        if (this.firmaDao == null) {
            this.firmaDao = new FirmaDAO();
        }
        return firmaDao;
    }

}
