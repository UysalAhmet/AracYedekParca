/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDAO;
import entity.User;
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
public class UserController implements Serializable{
     private List<User> userControllerList;
    private UserDAO userdao;
    private User user;
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
        this.pageCount=(int)Math.ceil(this.getUserdao().count()/(double)pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    

    
    public void updateForm(User user){
        this.user=user;
        
    }
    
    public void update(){
        this.getUserdao().update(this.user);
        this.user= new User();
    }
    
    
    public void delete(User user){
        this.getUserdao().delete(user);
        this.user= new User();
    }
    
    
    public void clearForm(){
        this.user= new User();
    }
    
    public void create(){
        
        this.getUserdao().insert(this.user);
        
        this.user= new User();
    }

    public List<User> getUserControllerList() {
        this.userControllerList=this.getUserdao().getUserList(page,pageSize);
        return userControllerList;
    }

    public void setUserControllerList(List<User> userControllerList) {
        this.userControllerList = userControllerList;
    }

    public UserDAO getUserdao() {
        if(this.userdao==null)
            this.userdao = new UserDAO();
        return userdao;
    }

    public void setUserdao(UserDAO userdao) {
        this.userdao = userdao;
    }

    public User getUser() {
        if(this.user==null)
            this.user = new User();
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
}
