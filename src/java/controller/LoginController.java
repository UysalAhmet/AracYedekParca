/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDAO;
import entity.User;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author ahmet
 */
@Named
@SessionScoped
public class LoginController implements Serializable{
    private User user;
    private UserDAO userDao;
    private boolean log=false;
    public String login(){
        String kullaniciAd=this.getUser().getKullaniciAd();
        String sifre = this.getUser().getSifre();
        String girilenKullaniciAd=this.getUserDao().userIdBul(kullaniciAd).getKullaniciAd();
        String girilenSifre=this.getUserDao().userIdBul(kullaniciAd).getSifre();
        System.out.println("");
        if(kullaniciAd.equals(girilenKullaniciAd) && sifre.equals(girilenSifre)){
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_user", this.user);
            this.setLog(true);
            return "/module/index?faces-redirect=true";
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(girilenKullaniciAd+"   ***    "+girilenSifre));
            this.setLog(false);
            return "Login";
        }

    }
    
    
    public User getUser() {
        if(this.user==null){
            this.user= new User();
        }
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserDAO getUserDao() {
        if(this.userDao==null){
            this.userDao= new UserDAO();
        }
        return userDao;
    }

    public void setUserDao(UserDAO userDao) {
        this.userDao = userDao;
    }

    public boolean isLog() {
        return log;
    }

    public void setLog(boolean log) {
        this.log = log;
    }
    
    
    
    
}
