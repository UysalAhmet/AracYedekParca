package controller;

import dao.MuhasebeciDAO;
import entity.Muhasebeci;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author gkhnya
 */

@Named
@SessionScoped
public class MuhasebeciController implements Serializable {

    private List<Muhasebeci> muhasebeciControllerList;
    private MuhasebeciDAO muhasebecidao;
    private Muhasebeci muhasebeci;
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
        this.pageCount = (int) Math.ceil(this.getMuhasebecidao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void updateForm(Muhasebeci muhasebeci) {
        this.muhasebeci = muhasebeci;

    }

    public void update() {
        this.getMuhasebecidao().update(this.muhasebeci);
        this.muhasebeci = new Muhasebeci();
    }

    public void delete(Muhasebeci muhasebeci) {
        this.getMuhasebecidao().delete(muhasebeci);
        this.muhasebeci = new Muhasebeci();
    }

    public void clearForm() {
        this.muhasebeci = new Muhasebeci();
    }

    public void create() {

        this.getMuhasebecidao().insert(this.muhasebeci);

        this.muhasebeci = new Muhasebeci();
    }

    public List<Muhasebeci> getMuhasebeciControllerList() {
        this.muhasebeciControllerList = this.getMuhasebecidao().getMuhasebeciList(page, pageSize);
        return muhasebeciControllerList;
    }

    public void setMuhasebeciControllerList(List<Muhasebeci> muhasebeciControllerList) {
        this.muhasebeciControllerList = muhasebeciControllerList;
    }

    public MuhasebeciDAO getMuhasebecidao() {
        if (this.muhasebecidao == null) {
            this.muhasebecidao = new MuhasebeciDAO();
        }
        return muhasebecidao;
    }

    public void setMuhasebecidao(MuhasebeciDAO muhasebecidao) {
        this.muhasebecidao = muhasebecidao;
    }

    public Muhasebeci getMuhasebeci() {
        if (this.muhasebeci == null) {
            this.muhasebeci = new Muhasebeci();
        }
        return muhasebeci;
    }

    public void setMuhasebeci(Muhasebeci muhasebeci) {
        this.muhasebeci = muhasebeci;
    }

}
