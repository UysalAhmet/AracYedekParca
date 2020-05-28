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
public class İsciController implements Serializable {
     private List<Isci> isciControllerList;
    private IsciDAO iscidao;
    private Isci isci;
    private Long selectedUsta;
    private UstaDAO ustaDao;
    private  List<Usta> ustaList;


    
    public void updateForm(Isci isci){
        this.isci=isci;
        this.selectedUsta=this.isci.getUsta().getUstaId();
        
    }
    
    public void update(){
        this.getIscidao().update(this.isci,selectedUsta);
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
        
        this.getIscidao().insert(this.isci,selectedUsta);
        
        this.isci= new Isci();
    }

    public List<Isci> getIsciControllerList() {
        this.isciControllerList=this.getIscidao().getIsciList();
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

    public Long getSelectedUsta() {
        return selectedUsta;
    }

    public void setSelectedUsta(Long selectedUsta) {
        this.selectedUsta = selectedUsta;
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
