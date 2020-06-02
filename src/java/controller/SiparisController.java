package controller;

import dao.MuhasebeciDAO;
import dao.ParcaDAO;
import dao.SiparisDAO;
import entity.Muhasebeci;
import entity.Parca;
import entity.Siparis;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author ahmet
 */

@Named
@SessionScoped
public class SiparisController implements Serializable {

    private List<Siparis> siparisControllerList;
    private SiparisDAO siparisdao;
    private Siparis siparis;
    private ParcaDAO parcaDao;
    private List<Parca> parcaList;
    private MuhasebeciDAO muhasebeciDao;
    private List<Muhasebeci> muhasebeciList;
    private int page = 1;
    private int pageSize = 5;
    private int pageCount;

    public void next() {
        if (this.page == this.getPageCount()) {
            this.page = 1;
        } else {
            this.page++;
        }

    }

    public void previous() {
        if (this.page == 1) {
            this.page = this.getPageCount();
        } else {
            this.page--;
        }

    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount = (int) Math.ceil(this.getSiparisdao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    @Inject
    private FirmaController firmaController;

    public void updateForm(Siparis siparis) {
        this.siparis = siparis;
    }

    public void update() {
        this.getSiparisdao().update(this.siparis);
        this.siparis = new Siparis();
    }

    public void delete(Siparis siparis) {
        this.getSiparisdao().delete(siparis);
        this.siparis = new Siparis();
    }

    public void clearForm() {
        this.siparis = new Siparis();
    }

    public void create() {

        this.getSiparisdao().insert(this.siparis);

        this.siparis = new Siparis();
    }

    public List<Siparis> getSiparisControllerList() {
        this.siparisControllerList = this.getSiparisdao().getSiparisList(page, pageSize);
        return siparisControllerList;
    }

    public void setSiparisControllerList(List<Siparis> siparisControllerList) {
        this.siparisControllerList = siparisControllerList;
    }

    public SiparisDAO getSiparisdao() {
        if (this.siparisdao == null) {
            this.siparisdao = new SiparisDAO();
        }
        return siparisdao;
    }

    public void setSiparisdao(SiparisDAO siparisdao) {
        this.siparisdao = siparisdao;
    }

    public Siparis getSiparis() {
        if (this.siparis == null) {
            this.siparis = new Siparis();
        }
        return siparis;
    }

    public void setSiparis(Siparis siparis) {
        this.siparis = siparis;
    }

    public ParcaDAO getParcaDao() {
        if (this.parcaDao == null) {
            this.parcaDao = new ParcaDAO();
        }
        return parcaDao;
    }

    public List<Parca> getParcaList() {
        this.parcaList = this.getParcaDao().getParcaList();
        return parcaList;
    }

    public void setParcaList(List<Parca> parcaList) {
        this.parcaList = parcaList;
    }

    public MuhasebeciDAO getMuhasebeciDao() {
        if (this.muhasebeciDao == null) {
            this.muhasebeciDao = new MuhasebeciDAO();
        }
        return muhasebeciDao;
    }

    public List<Muhasebeci> getMuhasebeciList() {
        this.muhasebeciList = this.getMuhasebeciDao().getMuhasebeciList();
        return muhasebeciList;
    }

    public void setMuhasebeciList(List<Muhasebeci> muhasebeciList) {
        this.muhasebeciList = muhasebeciList;
    }

    public FirmaController getFirmaController() {
        return firmaController;
    }

    public void setFirmaController(FirmaController firmaController) {
        this.firmaController = firmaController;
    }

}
