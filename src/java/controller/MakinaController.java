/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.IsciDAO;
import dao.MakinaDAO;
import dao.MakinaSorumlusuDAO;
import entity.Isci;
import entity.Makina;
import entity.MakinaSorumlusu;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


/**
 *
 * @author yasemin
 */
@Named
@SessionScoped
public class MakinaController implements Serializable {
    
     private List<Makina> makinaControllerList;
    private MakinaDAO makinadao;
    private Makina makina;
    private IsciDAO isciDao;
    private  List<Isci> isciList;
    private MakinaSorumlusuDAO makinaSorumlusuDao;
    private List<MakinaSorumlusu> makinaSorumlusuList;
   private int page=1;
    private int pageSize=5;
    private int pageCount;

    public void next(){
        if(this.page==this.getPageCount()){
            this.page=1;
        } else {
            this.page++;
        }
        
    }
    public void previous(){
        if(this.page==1){
            this.page=this.getPageCount();
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
        this.pageCount=(int)Math.ceil(this.getMakinadao().count()/(double)pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    

    
    public void updateForm(Makina makina){
        this.makina=makina;
        
    }
    
    public void update(){
        this.getMakinadao().update(this.makina);
        this.makina= new Makina();
    }
    
    
    public void delete(Makina makina){
        this.getMakinadao().delete(makina);
        this.makina= new Makina();
    }
    
    
    public void clearForm(){
        this.makina= new Makina();
    }
    
    public void create(){
        
        this.getMakinadao().insert(this.makina);
        
        this.makina= new Makina();
    }

    public List<Makina> getMakinaControllerList() {
        this.makinaControllerList=this.getMakinadao().getMakinaList(page,pageSize);
        return makinaControllerList;
    }

    public void setMakinaControllerList(List<Makina> makinaControllerList) {
        this.makinaControllerList = makinaControllerList;
    }

    public MakinaDAO getMakinadao() {
        if(this.makinadao==null)
            this.makinadao = new MakinaDAO();
        return makinadao;
    }

    public void setMakinadao(MakinaDAO makinadao) {
        this.makinadao = makinadao;
    }

    public Makina getMakina() {
        if(this.makina==null)
            this.makina = new Makina();
        return makina;
    }

    public void setMakina(Makina makina) {
        this.makina = makina;
    }

    

    public IsciDAO getIsciDao() {
        if(this.isciDao==null){
            this.isciDao= new IsciDAO();
        }
        return isciDao;
    }

    public List<Isci> getIsciList() {
        this.isciList=this.getIsciDao().getIsciList();
        return isciList;
    }

    public void setIsciList(List<Isci> isciList) {
        this.isciList = isciList;
    }

    public MakinaSorumlusuDAO getMakinaSorumlusuDao() {
        if(this.makinaSorumlusuDao==null){
            this.makinaSorumlusuDao=new MakinaSorumlusuDAO();
        }
        return makinaSorumlusuDao;
    }

   
    public List<MakinaSorumlusu> getMakinaSorumlusuList() {
        this.makinaSorumlusuList=this.getMakinaSorumlusuDao().getMakinaSorumlusuList();
        return makinaSorumlusuList;
    }

    public void setMakinaSorumlusuList(List<MakinaSorumlusu> makinaSorumlusuList) {
        this.makinaSorumlusuList = makinaSorumlusuList;
    }
    

}
