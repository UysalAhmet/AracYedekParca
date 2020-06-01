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

import dao.IsciDAO;
import dao.UstaDAO;
import entity.Isci;
import entity.Usta;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class IsciController implements Serializable{
     private List<Isci> isciControllerList;
    private IsciDAO iscidao;
    private Isci isci;
    private UstaDAO ustaDao;
    private  List<Usta> ustaList;
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
        this.pageCount=(int)Math.ceil(this.getIscidao().count()/(double)pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }


    
    public void updateForm(Isci isci){
        this.isci=isci;
        
    }
    
    public void update(){
        this.getIscidao().update(this.isci);
        this.isci= new Isci();
    }
    
    
    public void delete(Isci isci){
        this.getIscidao().delete(isci);
        this.isci= new Isci();
    }
    
    
    public void clearForm(){
        this.isci= new Isci();
    }
    
    public void create(){
        
        this.getIscidao().insert(this.isci);
        
        this.isci= new Isci();
    }

    public List<Isci> getIsciControllerList() {
        this.isciControllerList=this.getIscidao().getIsciList(page,pageSize);
        return isciControllerList;
    }

    public void setIsciControllerList(List<Isci> isciControllerList) {
        this.isciControllerList = isciControllerList;
    }

    public IsciDAO getIscidao() {
        if(this.iscidao==null)
            this.iscidao = new IsciDAO();
        return iscidao;
    }

    public void setIscidao(IsciDAO iscidao) {
        this.iscidao = iscidao;
    }

    public Isci getIsci() {
        if(this.isci==null)
            this.isci = new Isci();
        return isci;
    }

    public void setIsci(Isci isci) {
        this.isci = isci;
    }


    public UstaDAO getUstaDao() {
        if(this.ustaDao==null){
            this.ustaDao= new UstaDAO();
        }
        return ustaDao;
    }

    public List<Usta> getUstaList() {
        this.ustaList=this.getUstaDao().getUstaList();
        return ustaList;
    }

    public void setUstaList(List<Usta> ustaList) {
        this.ustaList = ustaList;
    }
    
  
}