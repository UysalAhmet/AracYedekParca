package dao;

import entity.Makina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DbConnection;

/**
 *
 * @author yasemin
 */

public class MakinaDAO {

    private DbConnection db;
    private Connection c;
    private MakinaSorumlusuDAO makinaSorumlusuDao;
    private IsciDAO isciDao;

    public List<Makina> getMakinaList() {
        List<Makina> makinaDaoList = new ArrayList();
        try {
            PreparedStatement pst = this.getC().prepareStatement("select * from makina");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Makina tmp = new Makina();
                tmp.setMakinaId(rs.getLong("makina_id"));
                tmp.setMakinaMarka(rs.getString("makina_marka"));
                tmp.setMakinaTur(rs.getString("makina_tur"));
                tmp.setIsci(this.getIsciDao().isciIdBul(rs.getLong("isci_id")));
                tmp.setMakinasorumlusu(this.getMakinaSorumlusuDao().makinaSorumlusuIdBul(rs.getLong("makinasorumlusu_id")));

                makinaDaoList.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return makinaDaoList;
    }

    public Makina makinaIdBul(Long makinaId) {
        Makina makina = null;

        try {

            PreparedStatement pst = this.getC().prepareStatement("select * from makina where makina_id=" + makinaId);
            ResultSet rs = pst.executeQuery();
            rs.next();
            makina = new Makina();
            makina.setMakinaId(rs.getLong("makina_id"));
            makina.setMakinaMarka(rs.getString("makina_marka"));
            makina.setMakinaTur(rs.getString("makina_tur"));
            makina.setIsci(this.getIsciDao().isciIdBul(rs.getLong("isci_id")));
            makina.setMakinasorumlusu(this.getMakinaSorumlusuDao().makinaSorumlusuIdBul(rs.getLong("makinasorumlusu_id")));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return makina;
    }

    public void insert(Makina makina, Long selectedMakinaSorumlusu, Long selectedIsci) {

        try {
            PreparedStatement pst = this.getC().prepareStatement("insert into makina "
                    + "(makina_marka,makina_tur,makinasorumlusu_id,isci_id) values(?,?,?,?)");
            pst.setString(1, makina.getMakinaMarka());
            pst.setString(2, makina.getMakinaTur());
            pst.setLong(3, selectedMakinaSorumlusu);
            pst.setLong(4, selectedIsci);

            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void delete(Makina makina) {

        try {
            PreparedStatement pst = this.getC().prepareStatement("delete from makina where makina_id=?");
            pst.setLong(1, makina.getMakinaId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void update(Makina makina, Long selectedMakinaSorumlusu, Long selectedIsci) {

        try {
            PreparedStatement pst = this.getC().prepareStatement("update makina set makina_marka=? ,makina_tur=?, makinasorumlusu_id=?, isci_id=?   where makina_id =?");
            pst.setString(1, makina.getMakinaMarka());
            pst.setString(2, makina.getMakinaTur());
            pst.setLong(3, selectedMakinaSorumlusu);
            pst.setLong(4, selectedIsci);
            pst.setLong(5, makina.getMakinaId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

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

    public MakinaSorumlusuDAO getMakinaSorumlusuDao() {
        if (this.makinaSorumlusuDao == null) {
            this.makinaSorumlusuDao = new MakinaSorumlusuDAO();
        }
        return makinaSorumlusuDao;
    }

    public IsciDAO getIsciDao() {
        if (this.isciDao == null) {
            this.isciDao = new IsciDAO();
        }
        return isciDao;
    }

}
