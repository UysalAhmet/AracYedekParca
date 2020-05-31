package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.MakinaSorumlusuDAO;
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
public class MakinaSorumlusuController implements Serializable{
    
    private List<MakinaSorumlusu> makinaSorumlusuControllerList;
    private MakinaSorumlusuDAO makinaSorumlusudao;
    private MakinaSorumlusu makinaSorumlusu;
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
        this.pageCount=(int)Math.ceil(this.getMakinaSorumlusudao().count()/(double)pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    

    
    public void updateForm(MakinaSorumlusu makinaSorumlusu){
        this.makinaSorumlusu=makinaSorumlusu;
        
    }
    
    public void update(){
        this.getMakinaSorumlusudao().update(this.makinaSorumlusu);
        this.makinaSorumlusu= new MakinaSorumlusu();
    }
    
    
    public void delete(MakinaSorumlusu makinaSorumlusu){
        this.getMakinaSorumlusudao().delete(makinaSorumlusu);
        this.makinaSorumlusu= new MakinaSorumlusu();
    }
    
    
    public void clearForm(){
        this.makinaSorumlusu= new MakinaSorumlusu();
    }
    
    public void create(){
        
        this.getMakinaSorumlusudao().insert(this.makinaSorumlusu);
        
        this.makinaSorumlusu= new MakinaSorumlusu();
    }

    public List<MakinaSorumlusu> getMakinaSorumlusuControllerList() {
        this.makinaSorumlusuControllerList=this.getMakinaSorumlusudao().getMakinaSorumlusuList(page,pageSize);
        return makinaSorumlusuControllerList;
    }

    public void setMakinaSorumlusuControllerList(List<MakinaSorumlusu> makinaSorumlusuControllerList) {
        this.makinaSorumlusuControllerList = makinaSorumlusuControllerList;
    }

    public MakinaSorumlusuDAO getMakinaSorumlusudao() {
        if(this.makinaSorumlusudao==null)
            this.makinaSorumlusudao = new MakinaSorumlusuDAO();
        return makinaSorumlusudao;
    }

    public void setMakinaSorumlusudao(MakinaSorumlusuDAO makinaSorumlusudao) {
        this.makinaSorumlusudao = makinaSorumlusudao;
    }

    public MakinaSorumlusu getMakinaSorumlusu() {
        if(this.makinaSorumlusu==null)
            this.makinaSorumlusu = new MakinaSorumlusu();
        return makinaSorumlusu;
    }

    public void setMakinaSorumlusu(MakinaSorumlusu makinaSorumlusu) {
        this.makinaSorumlusu = makinaSorumlusu;
    }
  
}
