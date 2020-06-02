package controller;

import dao.FirmaDAO;
import entity.Firma;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author gkhnya
 */

@Named
@SessionScoped
public class FirmaController implements Serializable {

    private List<Firma> firmaControllerList;
    private FirmaDAO firmadao;
    private Firma firma;
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
        this.pageCount = (int) Math.ceil(this.getFirmadao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    @Inject
    private SiparisController siparisController;

    public void updateForm(Firma firma) {
        this.firma = firma;

    }

    public void update() {
        this.getFirmadao().update(this.firma);
        this.firma = new Firma();
    }

    public void delete(Firma firma) {
        this.getFirmadao().delete(firma);

        this.firma = new Firma();
    }

    public void clearForm() {
        this.firma = new Firma();
    }

    public void create() {

        this.getFirmadao().insert(this.firma);

        this.firma = new Firma();
    }

    public List<Firma> getFirmaControllerList() {
        this.firmaControllerList = this.getFirmadao().getFirmaList(page, pageSize);
        return firmaControllerList;
    }

    public void setFirmaControllerList(List<Firma> firmaControllerList) {
        this.firmaControllerList = firmaControllerList;
    }

    public FirmaDAO getFirmadao() {
        if (this.firmadao == null) {
            this.firmadao = new FirmaDAO();
        }
        return firmadao;
    }

    public void setFirmadao(FirmaDAO firmadao) {
        this.firmadao = firmadao;
    }

    public Firma getFirma() {
        if (this.firma == null) {
            this.firma = new Firma();
        }
        return firma;
    }

    public void setFirma(Firma firma) {
        this.firma = firma;
    }

    public SiparisController getSiparisController() {
        return siparisController;
    }

}
