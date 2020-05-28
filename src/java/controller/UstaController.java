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
        this.ustaControllerList=this.getUstadao().getUstaList();
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
