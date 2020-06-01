/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author H Cem ERYILMAZ
 */

import dao.UstaDAO;
import entity.Usta;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class UstaController implements Serializable {
     private List<Usta> ustaControllerList;
    private UstaDAO ustadao;
    private Usta usta;
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
        this.pageCount=(int)Math.ceil(this.getUstadao().count()/(double)pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    
    
    public void updateForm(Usta usta){
        this.usta=usta;
        
    }
    
    public void update(){
        this.getUstadao().update(this.usta);
        this.usta= new Usta();
    }
    
    
    public void delete(Usta usta){
        this.getUstadao().delete(usta);
        this.usta= new Usta();
    }
    
    
    public void clearForm(){
        this.usta= new Usta();
    }
    
    public void create(){
        
        this.getUstadao().insert(this.usta);
        
        this.usta= new Usta();
    }

    public List<Usta> getUstaControllerList() {
        this.ustaControllerList=this.getUstadao().getUstaList(page,pageSize);
        return ustaControllerList;
    }

    public void setUstaControllerList(List<Usta> ustaControllerList) {
        this.ustaControllerList = ustaControllerList;
    }

    public UstaDAO getUstadao() {
        if(this.ustadao==null)
            this.ustadao = new UstaDAO();
        return ustadao;
    }

    public void setUstadao(UstaDAO ustadao) {
        this.ustadao = ustadao;
    }

    public Usta getUsta() {
        if(this.usta==null)
            this.usta = new Usta();
        return usta;
    }

    public void setUsta(Usta usta) {
        this.usta = usta;
    }
    
}