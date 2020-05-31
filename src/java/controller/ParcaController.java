/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.MakinaDAO;
import dao.ParcaDAO;
import entity.Makina;
import entity.Parca;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author ahmet
 */
@Named
@SessionScoped
public class ParcaController implements Serializable{
      private List<Parca> parcaControllerList;
    private ParcaDAO parcadao;
    private Parca parca;
    private MakinaDAO makinaDao;
    private  List<Makina> makinaList;
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
        this.pageCount=(int)Math.ceil(this.getParcadao().count()/(double)pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    

    
    public void updateForm(Parca parca){
        this.parca=parca;
        
    }
    
    public void update(){
        this.getParcadao().update(this.parca);
        this.parca= new Parca();
    }
    
    
    public void delete(Parca parca){
        this.getParcadao().delete(parca);
        this.parca= new Parca();
    }
    
    
    public void clearForm(){
        this.parca= new Parca();
    }
    
    public void create(){
        System.out.println("create metodu");
        this.getParcadao().insert(this.parca);
        
        this.parca= new Parca();
    }

    public List<Parca> getParcaControllerList() {
        this.parcaControllerList=this.getParcadao().getParcaList(page,pageSize);
        return parcaControllerList;
    }

    public void setParcaControllerList(List<Parca> parcaControllerList) {
        this.parcaControllerList = parcaControllerList;
    }

    public ParcaDAO getParcadao() {
        if(this.parcadao==null)
            this.parcadao = new ParcaDAO();
        return parcadao;
    }

    public void setParcadao(ParcaDAO parcadao) {
        this.parcadao = parcadao;
    }

    public Parca getParca() {
        if(this.parca==null)
            this.parca = new Parca();
        return parca;
    }

    public void setParca(Parca parca) {
        this.parca = parca;
    }

  
    public MakinaDAO getMakinaDao() {
        if(this.makinaDao==null){
            this.makinaDao= new MakinaDAO();
        }
        return makinaDao;
    }

    public List<Makina> getMakinaList() {
        this.makinaList=this.getMakinaDao().getMakinaList();
        return makinaList;
    }

    public void setMakinaList(List<Makina> makinaList) {
        this.makinaList = makinaList;
    }
    
}
